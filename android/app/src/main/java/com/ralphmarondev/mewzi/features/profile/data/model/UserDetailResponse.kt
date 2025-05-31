package com.ralphmarondev.mewzi.features.profile.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("username") val username: String,
    @SerializedName("date_joined") val dateJoined: String,
    @SerializedName("image") val image: String?
)