package com.ralphmarondev.mewzi.features.auth.di

import com.ralphmarondev.mewzi.features.auth.data.network.AuthService
import com.ralphmarondev.mewzi.features.auth.data.repository.AuthRepositoryImpl
import com.ralphmarondev.mewzi.features.auth.domain.repository.AuthRepository
import com.ralphmarondev.mewzi.features.auth.domain.usecase.LoginUseCase
import com.ralphmarondev.mewzi.features.auth.presentation.login.LoginViewModel
import com.ralphmarondev.mewzi.features.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {
    single { get<Retrofit>().create(AuthService::class.java) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }

    factoryOf(::LoginUseCase)

    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}