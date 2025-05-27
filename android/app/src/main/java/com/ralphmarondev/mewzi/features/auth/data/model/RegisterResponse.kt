package com.ralphmarondev.mewzi.features.auth.data.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("username") val username: String,
    @SerializedName("role_name") val roleName: String
)
