package com.ralphmarondev.mewzi.features.profile.data.network

import com.ralphmarondev.mewzi.features.profile.data.model.UserDetailResponse
import retrofit2.http.GET

interface ProfileApiService {

    @GET("user/")
    suspend fun getUserDetail(): UserDetailResponse
}