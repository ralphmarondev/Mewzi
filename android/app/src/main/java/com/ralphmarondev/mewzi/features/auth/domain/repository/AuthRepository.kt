package com.ralphmarondev.mewzi.features.auth.domain.repository

import com.ralphmarondev.mewzi.core.domain.model.Result

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String
    ): Result
}