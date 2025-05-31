package com.ralphmarondev.mewzi.features.feed.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.features.auth.domain.usecase.LoginUseCase
import com.ralphmarondev.mewzi.features.feed.domain.model.Post
import com.ralphmarondev.mewzi.features.feed.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FeedViewModel(
    private val preferences: AppPreferences,
    private val loginUseCase: LoginUseCase,
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    init {
        startPolling()
    }

    private fun startPolling() {
        viewModelScope.launch {
            if (!preferences.isFirstLaunch()) {
                try {
                    val username = preferences.getUsername()
                    val password = preferences.getUsername()

                    if (username.isNullOrBlank() || password.isNullOrBlank()) {
                        return@launch
                    }
                    loginUseCase(
                        username = username,
                        password = password
                    )
                } catch (e: Exception) {
                    Log.e("App", "Error getting token: ${e.message}")
                    return@launch
                }
            }

            while (true) {
                try {
                    val newPost = getPostsUseCase()
                    _posts.value = newPost
                } catch (e: Exception) {
                    Log.e("App", "Error: ${e.message}")
                }
                delay(60_000L) // 1 minute :)
            }
        }
    }

    fun refresh(onDone: () -> Unit) {
        viewModelScope.launch {
            _posts.value = getPostsUseCase()
            onDone()
        }
    }
}