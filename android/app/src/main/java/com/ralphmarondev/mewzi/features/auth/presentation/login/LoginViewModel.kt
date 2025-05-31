package com.ralphmarondev.mewzi.features.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.auth.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val preferences: AppPreferences
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()

    private val _showEnterServerDomainDialog = MutableStateFlow(false)
    val showEnterServerDomainDialog = _showEnterServerDomainDialog.asStateFlow()

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
        viewModelScope.launch {
            try {
                val result = loginUseCase(
                    username = _username.value,
                    password = _password.value
                )
                if (result.success) {
                    preferences.setUsername(_username.value.trim())
                    preferences.setPassword(_password.value.trim())
                }
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

    fun setShowServerDomainDialog(value: Boolean) {
        _showEnterServerDomainDialog.value = value
    }

    fun setupServerDomain(value: String) {
        viewModelScope.launch {

            if (value.isBlank()) {
                _response.value = Result(
                    success = false,
                    message = "Invalid ip address."
                )
                return@launch
            }

            preferences.setIpAdress(value)
            _response.value = Result(
                success = false, // can't be true, it will navigate to home.
                message = "Server domain updated successfully. Restart to take affect."
            )
            _showEnterServerDomainDialog.value = false
        }
    }
}