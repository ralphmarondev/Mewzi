package com.ralphmarondev.mewzi.features.new_post.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewPostViewModel : ViewModel() {

    private val _caption = MutableStateFlow("")
    val caption = _caption.asStateFlow()


    fun onCaptionValueChange(value: String) {
        _caption.value = value
    }

    fun post() {
        viewModelScope.launch {
            Log.d("App", "Caption: `${_caption.value}`")
        }
    }
}