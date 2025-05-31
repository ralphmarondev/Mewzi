package com.ralphmarondev.mewzi.features.home.presentation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PostAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.util.fastForEachIndexed
import androidx.navigation.NavHostController
import com.ralphmarondev.mewzi.features.feed.presentation.FeedScreen
import com.ralphmarondev.mewzi.features.new_post.presentation.NewPostScreen
import com.ralphmarondev.mewzi.features.profile.presentation.overview.ProfileScreen
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val viewModel: HomeViewModel = koinViewModel()
    val currentIndex = viewModel.currentIndex.collectAsState().value
    val snackbarState = remember { SnackbarHostState() }

    val navItems = listOf(
        NavItems(
            selected = currentIndex == 0,
            selectedIcon = Icons.Filled.Home,
            defaultIcon = Icons.Outlined.Home,
            onClick = { viewModel.onCurrentIndexValueChange(0) },
            label = "Feed"
        ),
        NavItems(
            selected = currentIndex == 1,
            selectedIcon = Icons.Filled.PostAdd,
            defaultIcon = Icons.Outlined.PostAdd,
            onClick = { viewModel.onCurrentIndexValueChange(1) },
            label = "New Post"
        ),
        NavItems(
            selected = currentIndex == 2,
            selectedIcon = Icons.Filled.AccountCircle,
            defaultIcon = Icons.Outlined.AccountCircle,
            onClick = { viewModel.onCurrentIndexValueChange(2) },
            label = "Profile"
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.fastForEachIndexed { _, navItems ->
                    NavigationBarItem(
                        selected = navItems.selected,
                        icon = {
                            Icon(
                                imageVector = if (navItems.selected) navItems.selectedIcon else navItems.defaultIcon,
                                contentDescription = navItems.label
                            )
                        },
                        onClick = navItems.onClick,
                        label = {
                            Text(
                                text = navItems.label
                            )
                        }
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(snackbarState)
        }
    ) {
        when (currentIndex) {
            0 -> FeedScreen()
            1 -> NewPostScreen(snackbarState)
            2 -> ProfileScreen(navController)
        }
    }
}

private data class NavItems(
    val selected: Boolean,
    val selectedIcon: ImageVector,
    val defaultIcon: ImageVector,
    val onClick: () -> Unit,
    val label: String
)