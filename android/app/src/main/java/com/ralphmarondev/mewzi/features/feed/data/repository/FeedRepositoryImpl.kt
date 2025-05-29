package com.ralphmarondev.mewzi.features.feed.data.repository

import com.ralphmarondev.mewzi.features.feed.data.network.FeedService
import com.ralphmarondev.mewzi.features.feed.domain.model.Post
import com.ralphmarondev.mewzi.features.feed.domain.repository.FeedRepository

class FeedRepositoryImpl(
    private val service: FeedService
) : FeedRepository {
    override suspend fun getPosts(): List<Post> {
        return service.getAllPosts().map {
            Post(
                id = it.id,
                ownerUsername = it.ownerUsername,
                ownerImage = it.ownerImage,
                caption = it.caption,
                image = it.image,
                uploadDate = it.createDate
            )
        }
    }
}