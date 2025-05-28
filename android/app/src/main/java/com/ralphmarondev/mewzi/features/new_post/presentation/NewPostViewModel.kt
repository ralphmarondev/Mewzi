package com.ralphmarondev.mewzi.features.new_post.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.new_post.domain.usecase.CreateNewPostUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewPostViewModel(
    private val createNewPostUseCase: CreateNewPostUseCase
) : ViewModel() {

    private val _caption = MutableStateFlow("")
    val caption = _caption.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()


    fun onCaptionValueChange(value: String) {
        _caption.value = value
    }

    fun post() {
        viewModelScope.launch {
            Log.d("App", "Caption: `${_caption.value}`")

            try {
                val result = createNewPostUseCase(caption = _caption.value)
                _response.value = result
            } catch (e: Exception) {
                _response.value = Result(
                    success = false,
                    message = "Creation of post failed."
                )
            }
        }
    }

    fun clearResponse() {
        _response.value = null
    }
}