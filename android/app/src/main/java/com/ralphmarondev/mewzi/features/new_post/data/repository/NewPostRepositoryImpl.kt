package com.ralphmarondev.mewzi.features.new_post.data.repository

import com.ralphmarondev.mewzi.features.new_post.data.network.NewPostService
import com.ralphmarondev.mewzi.features.new_post.domain.repository.NewPostRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class NewPostRepositoryImpl(
    private val service: NewPostService
) : NewPostRepository {
    override suspend fun create(caption: RequestBody, image: MultipartBody.Part?) {
        service.create(caption, image)
    }
}