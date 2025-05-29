package com.ralphmarondev.mewzi.features.feed.di

import com.ralphmarondev.mewzi.features.feed.presentation.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val feedModule = module {
    viewModelOf(::FeedViewModel)
}