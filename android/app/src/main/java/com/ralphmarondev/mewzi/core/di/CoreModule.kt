package com.ralphmarondev.mewzi.core.di

import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.util.ThemeState
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val IP_ADDRESS = ""
private const val BASE_URL = "http://$IP_ADDRESS:8000/api/"

val coreModule = module {
    singleOf(::AppPreferences)
    singleOf(::ThemeState)

    single<Interceptor> {
        Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("X-Tenant-ID", "tenant1")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}