package com.ralphmarondev.mewzi.features.new_post.domain.repository

interface NewPostRepository {
    suspend fun create(caption: String)
}