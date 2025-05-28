package com.ralphmarondev.mewzi.core.data.network

import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val preferences: AppPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = preferences.getAccessToken()
        val request = chain.request().newBuilder()

        token?.let {
            request.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(request.build())
    }
}