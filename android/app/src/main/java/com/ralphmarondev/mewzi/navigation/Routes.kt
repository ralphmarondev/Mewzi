package com.ralphmarondev.mewzi.navigation

import kotlinx.serialization.Serializable

object Routes {

    @Serializable
    data object Onboarding

    @Serializable
    data object Login

    @Serializable
    data object Register

    @Serializable
    data object Home

    @Serializable
    data object EditProfile
}