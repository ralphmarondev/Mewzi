package com.ralphmarondev.mewzi.features.auth.presentation.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()

    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _gender = MutableStateFlow("")
    val gender = _gender.asStateFlow()

    private val _mobileNo = MutableStateFlow("")
    val mobileNo = _mobileNo.asStateFlow()


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

    fun onEmailValueChange(value: String) {
        _email.value = value
    }

    fun onGenderValueChange(value: String) {
        _gender.value = value
    }

    fun onMobileNoValueChange(value: String) {
        _mobileNo.value = value
    }

    fun register() {
        viewModelScope.launch {
            Log.d("App", "Registration values...")
            Log.d(
                "App",
                "First name: `${_firstName.value}`, Last name: `${_lastName.value}`, username: `${_username.value}`, password: `${_password.value}`"
            )
            Log.d(
                "App",
                "Email: `${_email.value}`, mobile no: `${_mobileNo.value}`, gender: `${_gender.value}`"
            )
        }
    }
}