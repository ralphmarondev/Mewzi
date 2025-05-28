package com.ralphmarondev.mewzi.features.new_post.data.network

import com.ralphmarondev.mewzi.features.new_post.data.model.NewPostRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface NewPostService {

    @POST("posts/")
    suspend fun create(
        @Body request: NewPostRequest
    )
}