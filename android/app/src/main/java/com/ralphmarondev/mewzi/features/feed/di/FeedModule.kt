package com.ralphmarondev.mewzi.features.feed.di

import com.ralphmarondev.mewzi.features.feed.data.network.FeedService
import com.ralphmarondev.mewzi.features.feed.data.repository.FeedRepositoryImpl
import com.ralphmarondev.mewzi.features.feed.domain.repository.FeedRepository
import com.ralphmarondev.mewzi.features.feed.domain.usecase.GetPostsUseCase
import com.ralphmarondev.mewzi.features.feed.presentation.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val feedModule = module {
    single { get<Retrofit>().create(FeedService::class.java) }
    single<FeedRepository> { FeedRepositoryImpl(get()) }

    factoryOf(::GetPostsUseCase)

    viewModelOf(::FeedViewModel)
}