package com.ralphmarondev.mewzi.features.new_post.data.model

import com.google.gson.annotations.SerializedName

data class NewPostRequest(
    @SerializedName("caption") val caption: String
)