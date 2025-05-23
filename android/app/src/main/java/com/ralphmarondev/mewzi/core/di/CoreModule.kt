package com.ralphmarondev.mewzi.core.di

import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.util.ThemeState
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreModule = module {
    singleOf(::AppPreferences)
    singleOf(::ThemeState)
}