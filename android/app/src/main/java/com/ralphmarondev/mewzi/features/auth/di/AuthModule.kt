package com.ralphmarondev.mewzi.features.auth.di

import com.ralphmarondev.mewzi.features.auth.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authModule = module {
    viewModelOf(::LoginViewModel)
}