package com.ralphmarondev.mewzi.features.new_post.data.network

import com.ralphmarondev.mewzi.features.new_post.data.model.NewPostRequest
import retrofit2.http.Body

interface NewPostService {

    suspend fun create(
        @Body request: NewPostRequest
    )
}