package com.ralphmarondev.mewzi.features.feed.domain.repository

import com.ralphmarondev.mewzi.features.feed.domain.model.Post

interface FeedRepository {

    suspend fun getPosts(): List<Post>
}