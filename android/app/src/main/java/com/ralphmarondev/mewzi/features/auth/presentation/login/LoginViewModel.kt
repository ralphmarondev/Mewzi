package com.ralphmarondev.mewzi.features.auth.presentation.login

import androidx.lifecycle.ViewModel
import com.ralphmarondev.mewzi.features.auth.domain.model.AuthResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _response = MutableStateFlow(AuthResponse())
    val response = _response.asStateFlow()

    private val _showForgotPasswordDialog = MutableStateFlow(false)
    val showForgotPasswordDialog = _showForgotPasswordDialog.asStateFlow()


    fun onUsernameValueChange(value: String) {
        _username.value = value
    }

    fun onPasswordValueChange(value: String) {
        _password.value = value
    }

    fun setShowForgotPasswordDialogValue(value: Boolean) {
        _showForgotPasswordDialog.value = value
    }

    fun login() {

    }
}