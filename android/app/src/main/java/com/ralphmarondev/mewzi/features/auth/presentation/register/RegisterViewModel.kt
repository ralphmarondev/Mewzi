package com.ralphmarondev.mewzi.features.auth.presentation.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.domain.model.Result
import com.ralphmarondev.mewzi.features.auth.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val preferences: AppPreferences,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()

    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()


    fun onFirstNameValueChange(value: String) {
        _firstName.value = value
    }

    fun onLastNameValueChange(value: String) {
        _lastName.value = value
    }

    fun onUsernameValueChange(value: String) {
        _username.value = value
    }

    fun onPasswordValueChange(value: String) {
        _password.value = value
    }


    fun register() {
        viewModelScope.launch {
            Log.d("App", "Registration values...")
            Log.d(
                "App",
                "First name: `${_firstName.value}`, Last name: `${_lastName.value}`, username: `${_username.value}`, password: `${_password.value}`"
            )
            try {
                val result = registerUseCase(
                    firstName = _firstName.value,
                    lastName = _lastName.value,
                    username = _username.value,
                    password = _password.value
                )
                if (result.success) {
                    preferences.setUsername(_username.value.trim())
                    preferences.setPassword(_password.value.trim())
                }
                _response.value = result
            } catch (e: Exception) {
                Log.e("App", "Registration failed. Error: ${e.message}")
                _response.value = Result(
                    success = false,
                    message = "Registration failed."
                )
            }
        }
    }
}