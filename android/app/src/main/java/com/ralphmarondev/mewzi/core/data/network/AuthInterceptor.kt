package com.ralphmarondev.mewzi.core.data.network

import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val preferences: AppPreferences
) : Interceptor {

    private val publicEndpoints = listOf(
        "registration/",
        "token/"
    )

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlPath = request.url.encodedPath

        val isPublic = publicEndpoints.any { endpoint ->
            urlPath.endsWith(endpoint)
        }
        val newRequestBuilder = request.newBuilder()

        if (!isPublic) {
            preferences.getAccessToken()?.let { token ->
                newRequestBuilder.addHeader("Authorization", "Bearer $token")
            }
        }

        return chain.proceed(newRequestBuilder.build())
    }
}