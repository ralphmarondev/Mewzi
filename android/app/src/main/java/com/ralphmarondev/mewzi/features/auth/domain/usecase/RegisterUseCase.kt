package com.ralphmarondev.mewzi.features.auth.domain.usecase

import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.auth.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Result {
        if (firstName.isBlank() && lastName.isBlank() && username.isBlank() && password.isBlank()) {
            return Result(
                success = false,
                message = "Please fill in all fields."
            )
        }
        if (firstName.isBlank()) {
            return Result(
                success = false,
                message = "First name cannot be empty."
            )
        }
        if (lastName.isBlank()) {
            return Result(
                success = false,
                message = "Last name cannot be empty."
            )
        }
        if (username.isBlank()) {
            return Result(
                success = false,
                message = "Username cannot be empty."
            )
        }
        if (password.isBlank()) {
            return Result(
                success = false,
                message = "Password cannot be empty."
            )
        }

        val result = repository.register(
            firstName = firstName,
            lastName = lastName,
            username = username,
            password = password
        )
        return result
    }
}