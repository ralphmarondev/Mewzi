package com.ralphmarondev.mewzi.features.auth.data.network

import com.ralphmarondev.mewzi.features.auth.data.model.LoginRequest
import com.ralphmarondev.mewzi.features.auth.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("token/")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}