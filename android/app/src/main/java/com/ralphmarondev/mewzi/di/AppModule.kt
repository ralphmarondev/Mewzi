package com.ralphmarondev.mewzi.di

import com.ralphmarondev.mewzi.core.di.coreModule
import com.ralphmarondev.mewzi.features.auth.di.authModule
import com.ralphmarondev.mewzi.features.home.di.homeModule

val appModule = listOf(
    coreModule,
    authModule,
    homeModule
)