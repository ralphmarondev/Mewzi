package com.ralphmarondev.mewzi.features.feed.domain.usecase

import com.ralphmarondev.mewzi.features.feed.domain.repository.FeedRepository

class GetPostsUseCase(
    private val repository: FeedRepository
) {
    suspend operator fun invoke() = repository.getPosts()
}