package com.ralphmarondev.mewzi.core.di

import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.data.network.AuthInterceptor
import com.ralphmarondev.mewzi.core.util.ThemeState
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// NOTE: temporary -> May 31, 2025 @ 7:39AM
const val BASE_URL = "http://192.168.68.119:8000"

val coreModule = module {
    singleOf(::AppPreferences)
    singleOf(::ThemeState)

    // register auth interceptor using app preferences
    single<Interceptor> { AuthInterceptor(get<AppPreferences>()) }

    // okHttpClient with auth interceptor
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("X-Tenant-ID", "tenant1")
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
//        val preferences = get<AppPreferences>()
//        val baseUrl = buildBaseUrl(preferences)
        val baseUrl = "$BASE_URL/api/"

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

private fun buildBaseUrl(preferences: AppPreferences): String {
    val ip = preferences.getIpAddress()
        ?.takeIf { it.matches(Regex("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) }
        ?: "10.0.2.2"

    return "http://$ip:8000/api/"
}