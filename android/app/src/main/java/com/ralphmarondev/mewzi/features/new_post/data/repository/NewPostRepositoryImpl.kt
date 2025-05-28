package com.ralphmarondev.mewzi.features.new_post.data.repository

import com.ralphmarondev.mewzi.features.new_post.data.model.NewPostRequest
import com.ralphmarondev.mewzi.features.new_post.data.network.NewPostService
import com.ralphmarondev.mewzi.features.new_post.domain.repository.NewPostRepository

class NewPostRepositoryImpl(
    private val service: NewPostService
) : NewPostRepository {
    override suspend fun create(caption: String) {
        service.create(
            request = NewPostRequest(
                caption = caption
            )
        )
    }
}