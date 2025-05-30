package com.ralphmarondev.mewzi.features.new_post.data.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface NewPostService {

    @Multipart
    @POST("posts/")
    suspend fun create(
        @Part("caption") caption: RequestBody,
        @Part image: MultipartBody.Part? = null
    )
}