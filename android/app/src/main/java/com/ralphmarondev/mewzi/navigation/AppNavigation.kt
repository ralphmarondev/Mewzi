package com.ralphmarondev.mewzi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.mewzi.core.data.local.preferences.AppPreferences
import com.ralphmarondev.mewzi.core.util.LocalThemeState
import com.ralphmarondev.mewzi.features.auth.presentation.login.LoginScreen
import com.ralphmarondev.mewzi.features.auth.presentation.register.RegisterScreen
import com.ralphmarondev.mewzi.features.home.presentation.HomeScreen
import com.ralphmarondev.mewzi.features.onboarding.presentation.OnboardingScreen
import com.ralphmarondev.mewzi.features.profile.presentation.edit_profile.EditProfileScreen
import com.ralphmarondev.mewzi.ui.theme.MewziTheme

@Composable
fun AppNavigation(
    preferences: AppPreferences,
    navController: NavHostController = rememberNavController()
) {
    val themeState = LocalThemeState.current
    val startDestination: Any = if (preferences.isFirstLaunch()) {
        Routes.Onboarding
    } else {
        Routes.Home
    }

    MewziTheme(
        darkTheme = themeState.darkTheme.value
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable<Routes.Onboarding> {
                OnboardingScreen(
                    navigateToLogin = {
                        navController.navigate(Routes.Login) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    navigateToRegister = {
                        navController.navigate(Routes.Register) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.Login> {
                LoginScreen(
                    navigateToRegister = {
                        navController.navigate(Routes.Register) {
                            launchSingleTop = true
                        }
                    },
                    navigateToHome = {
                        navController.navigate(Routes.Home) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                            preferences.setFirstLaunch()
                        }
                    }
                )
            }
            composable<Routes.Register> {
                RegisterScreen(
                    navigateToLogin = {
                        navController.navigate(Routes.Login) {
                            launchSingleTop = true
                        }
                    },
                    navigateToHome = {
                        navController.navigate(Routes.Home) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                            preferences.setFirstLaunch()
                        }
                    }
                )
            }
            composable<Routes.Home> {
                HomeScreen(navController)
            }
            composable<Routes.EditProfile> {
                EditProfileScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}