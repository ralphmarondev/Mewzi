package com.ralphmarondev.mewzi.features.new_post.data.model

data class NewPostRequest(
    val caption: String,
    val image: String? = null
)