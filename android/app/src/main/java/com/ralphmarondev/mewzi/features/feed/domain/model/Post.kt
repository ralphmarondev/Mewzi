package com.ralphmarondev.mewzi.features.feed.domain.model

data class Post(
    val id: Int = 0,
    val ownerUsername: String,
    val ownerImage: String?,
    val caption: String,
    val image: String?,
    val uploadDate: String?
)