package com.ralphmarondev.mewzi.features.feed.data.network

import com.ralphmarondev.mewzi.features.feed.data.model.FeedResponse
import retrofit2.http.GET

interface FeedService {

    @GET("posts/")
    suspend fun getAllPosts(): List<FeedResponse>
}
