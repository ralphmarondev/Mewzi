package com.ralphmarondev.mewzi.features.profile.data.repository

import com.ralphmarondev.mewzi.features.profile.data.network.ProfileApiService
import com.ralphmarondev.mewzi.features.profile.domain.model.User
import com.ralphmarondev.mewzi.features.profile.domain.repository.ProfileRepository

class ProfileRepositoryImpl(
    private val service: ProfileApiService
) : ProfileRepository {
    override suspend fun getUserDetails(): User {
        val response = service.getUserDetail()

        return User(
            firstName = response.firstName,
            lastName = response.lastName,
            username = response.username,
            dateJoined = response.dateJoined,
            image = response.image
        )
    }
}