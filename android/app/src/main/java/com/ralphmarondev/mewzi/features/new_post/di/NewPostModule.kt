package com.ralphmarondev.mewzi.features.new_post.di

import com.ralphmarondev.mewzi.features.new_post.presentation.NewPostViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val newPostModule = module {
    viewModelOf(::NewPostViewModel)
}