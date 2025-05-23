package com.ralphmarondev.mewzi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.mewzi.core.util.LocalThemeState
import com.ralphmarondev.mewzi.features.auth.presentation.login.LoginScreen
import com.ralphmarondev.mewzi.features.auth.presentation.register.RegisterScreen
import com.ralphmarondev.mewzi.features.home.presentation.HomeScreen
import com.ralphmarondev.mewzi.ui.theme.MewziTheme

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    val themeState = LocalThemeState.current

    MewziTheme(
        darkTheme = themeState.darkTheme.value
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.Login
        ) {
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
                        }
                    }
                )
            }
            composable<Routes.Register> {
                RegisterScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable<Routes.Home> {
                HomeScreen(
                    darkTheme = false,
                    toggleDarkTheme = {}
                )
            }
        }
    }
}