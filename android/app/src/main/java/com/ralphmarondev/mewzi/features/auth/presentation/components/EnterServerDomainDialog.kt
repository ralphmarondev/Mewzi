package com.ralphmarondev.mewzi.features.auth.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NetworkPing
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun EnterServerDomainDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var ipAddress by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(ipAddress)
                }
            ) {
                Text(
                    text = "Save",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(
                    text = "Cancel",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        },
        text = {
            NormalTextField(
                value = ipAddress,
                onValueChange = { ipAddress = it },
                leadingIcon = Icons.Outlined.NetworkPing,
                placeholder = "192.168.68.119",
                label = "Server Domain"
            )
        },
        title = {
            Text(
                text = "Enter Server Domain",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary
            )
        }
    )
}