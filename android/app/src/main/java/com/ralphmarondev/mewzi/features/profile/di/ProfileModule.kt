package com.ralphmarondev.mewzi.features.profile.di

import com.ralphmarondev.mewzi.features.profile.data.network.ProfileApiService
import com.ralphmarondev.mewzi.features.profile.data.repository.ProfileRepositoryImpl
import com.ralphmarondev.mewzi.features.profile.domain.repository.ProfileRepository
import com.ralphmarondev.mewzi.features.profile.domain.usecase.GetUserDetailUseCase
import com.ralphmarondev.mewzi.features.profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val profileModule = module {
    single { get<Retrofit>().create(ProfileApiService::class.java) }
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }

    factoryOf(::GetUserDetailUseCase)

    viewModelOf(::ProfileViewModel)
}