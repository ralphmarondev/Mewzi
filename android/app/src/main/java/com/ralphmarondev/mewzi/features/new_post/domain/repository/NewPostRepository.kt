package com.ralphmarondev.mewzi.features.new_post.domain.repository

import okhttp3.MultipartBody
import okhttp3.RequestBody

interface NewPostRepository {
    suspend fun create(caption: RequestBody, image: MultipartBody.Part? = null)
}