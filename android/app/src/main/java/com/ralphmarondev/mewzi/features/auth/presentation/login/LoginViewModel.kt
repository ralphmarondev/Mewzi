package com.ralphmarondev.mewzi.features.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.auth.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()


    fun onUsernameValueChange(value: String) {
        _username.value = value
    }

    fun onPasswordValueChange(value: String) {
        _password.value = value
    }

    fun login() {
        viewModelScope.launch {
            try {
                val result = loginUseCase(
                    username = _username.value,
                    password = _password.value
                )
                _response.value = result
            } catch (e: Exception) {
                _response.value = Result(
                    success = false,
                    message = "Login failed."
                )
            }
        }
    }

    fun clearResponse() {
        _response.value = null
    }
}