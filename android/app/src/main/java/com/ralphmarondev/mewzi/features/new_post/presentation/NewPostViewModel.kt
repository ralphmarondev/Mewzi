package com.ralphmarondev.mewzi.features.new_post.presentation

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
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

    private val _image = MutableStateFlow("")
    val image = _image.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()


    fun onCaptionValueChange(value: String) {
        _caption.value = value
    }

    fun setImageValue(value: String) {
        _image.value = value
    }

    fun post(context: Context) {
        viewModelScope.launch {
            Log.d("App", "Caption: `${_caption.value}`")

            try {
                val uri = _image.value.toUri()
                val imagePart = uriToMultipart(context, uri)
                val result = createNewPostUseCase(_caption.value, imagePart)
                _response.value = result

                if (result.success) {
                    _caption.value = ""
                    _image.value = ""
                }
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