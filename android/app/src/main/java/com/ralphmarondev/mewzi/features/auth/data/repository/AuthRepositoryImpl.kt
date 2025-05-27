package com.ralphmarondev.mewzi.features.auth.data.repository

import android.util.Log
import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.auth.data.model.LoginRequest
import com.ralphmarondev.mewzi.features.auth.data.model.RegisterRequest
import com.ralphmarondev.mewzi.features.auth.data.network.AuthService
import com.ralphmarondev.mewzi.features.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val preferences: AppPreferences
) : AuthRepository {
    override suspend fun login(username: String, password: String): Result {
        val result = authService.login(
            request = LoginRequest(
                username = username,
                password = password
            )
        )
        if (result.access.isNotBlank() && result.refresh.isNotBlank()) {
            Log.d("App", "Access: `${result.access}`, Refresh: `${result.refresh}`")
            preferences.setAccessToken(result.access)
            preferences.setRefreshToken(result.refresh)

            return Result(
                success = true,
                message = "Login successful."
            )
        }
        return Result(
            success = false,
            message = "Login failed."
        )
    }

    override suspend fun register(
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Result {
        val result = authService.register(
            request = RegisterRequest(
                firstName = firstName,
                lastName = lastName,
                username = username,
                password = password
            )
        )

        if (result.username.isNotBlank() || result.roleName.isNotBlank()) {
            Log.d("App", "Registration successful.")

            return Result(
                success = true,
                message = "Registration successful."
            )
        }
        return Result(
            success = false,
            message = "Registration failed."
        )
    }
}