package com.ralphmarondev.mewzi.features.profile.domain.repository

import com.ralphmarondev.mewzi.features.profile.domain.model.User

interface ProfileRepository {
    suspend fun getUserDetails(): User
}