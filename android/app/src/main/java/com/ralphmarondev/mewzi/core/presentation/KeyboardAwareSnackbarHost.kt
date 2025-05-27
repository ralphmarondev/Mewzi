package com.ralphmarondev.mewzi.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

// With this custom snackbar, the snackbar will float above the keyboard instead of being blocked by it.
@Composable
fun KeyboardAwareSnackbarHost(
    snackbarHostState: SnackbarHostState
) {
    val imeInsets = WindowInsets.ime
    val density = LocalDensity.current

    val bottomPadding = with(density) {
        imeInsets.getBottom(this).toDp().takeIf { it > 0.dp } ?: 8.dp
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(bottom = bottomPadding)
    ) {
        SnackbarHost(hostState = snackbarHostState)
    }
}