package com.ralphmarondev.mewzi.features.new_post.domain.usecase

import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.new_post.domain.repository.NewPostRepository

class CreateNewPostUseCase(
    private val repository: NewPostRepository
) {
    suspend operator fun invoke(caption: String): Result {
        if (caption.isBlank()) {
            return Result(
                success = false,
                message = "Caption cannot be empty."
            )
        }

        repository.create(caption)
        return Result(
            success = true,
            message = "Post created successfully."
        )
    }
}