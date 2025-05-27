package com.ralphmarondev.mewzi.features.auth.data.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("role") val role: Int = 2,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
)
