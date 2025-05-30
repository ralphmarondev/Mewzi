package com.ralphmarondev.mewzi.features.new_post.domain.usecase

import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.new_post.domain.repository.NewPostRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

class CreateNewPostUseCase(
    private val repository: NewPostRepository
) {
    suspend operator fun invoke(caption: String, image: MultipartBody.Part? = null): Result {
        if (caption.isBlank()) {
            return Result(
                success = false,
                message = "Caption cannot be empty."
            )
        }

        val captionBody = caption.toRequestBody("text/plain".toMediaTypeOrNull())
        return try {
            repository.create(captionBody, image)
            return Result(
                success = true,
                message = "Post created successfully."
            )
        } catch (e: Exception) {
            Result(
                success = false,
                message = "Error :${e.localizedMessage}"
            )
        }
    }
}