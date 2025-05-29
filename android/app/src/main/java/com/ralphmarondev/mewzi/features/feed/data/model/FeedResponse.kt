package com.ralphmarondev.mewzi.features.feed.data.model

import com.google.gson.annotations.SerializedName

data class FeedResponse(
    val id: Int,
    @SerializedName("owner_username")
    val ownerUsername: String,
    @SerializedName("owner_image")
    val ownerImage: String,
    val image: String,
    val caption: String,
    val createDate: String,
    val owner: Int
)
