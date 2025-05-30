package com.ralphmarondev.mewzi.features.profile.domain.usecase

import com.ralphmarondev.mewzi.features.profile.domain.model.User
import com.ralphmarondev.mewzi.features.profile.domain.repository.ProfileRepository

class GetUserDetailUseCase(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(): User {
        return repository.getUserDetails()
    }
}