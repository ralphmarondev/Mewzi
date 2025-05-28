package com.ralphmarondev.mewzi.features.new_post.di

import com.ralphmarondev.mewzi.features.new_post.data.network.NewPostService
import com.ralphmarondev.mewzi.features.new_post.data.repository.NewPostRepositoryImpl
import com.ralphmarondev.mewzi.features.new_post.domain.repository.NewPostRepository
import com.ralphmarondev.mewzi.features.new_post.domain.usecase.CreateNewPostUseCase
import com.ralphmarondev.mewzi.features.new_post.presentation.NewPostViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val newPostModule = module {
    single<NewPostService> { get<Retrofit>().create(NewPostService::class.java) }
    single<NewPostRepository> { NewPostRepositoryImpl(get()) }

    factoryOf(::CreateNewPostUseCase)

    viewModelOf(::NewPostViewModel)
}