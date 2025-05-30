package com.ralphmarondev.mewzi.di

import com.ralphmarondev.mewzi.core.di.coreModule
import com.ralphmarondev.mewzi.features.auth.di.authModule
import com.ralphmarondev.mewzi.features.feed.di.feedModule
import com.ralphmarondev.mewzi.features.home.di.homeModule
import com.ralphmarondev.mewzi.features.new_post.di.newPostModule
import com.ralphmarondev.mewzi.features.profile.di.profileModule

val appModule = listOf(
    coreModule,
    authModule,
    homeModule,
    newPostModule,
    feedModule,
    profileModule
)