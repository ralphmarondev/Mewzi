package com.ralphmarondev.mewzi.di

import com.ralphmarondev.mewzi.core.di.coreModule
import com.ralphmarondev.mewzi.features.auth.di.authModule

val appModule = listOf(
    coreModule,
    authModule
)