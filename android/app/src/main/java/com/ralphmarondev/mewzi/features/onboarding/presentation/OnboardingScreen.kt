package com.ralphmarondev.mewzi.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.mewzi.R
import com.ralphmarondev.mewzi.core.util.StatusBarStyle

@Composable
fun OnboardingScreen(
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit
) {
    val darkTheme = isSystemInDarkTheme()
    StatusBarStyle(!darkTheme)

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.transparent_logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(300.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Where Ideas Purr!",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Social app where soft thoughts, tiny rambles, and meow-worthy moments live.",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = navigateToLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Let Meow In",
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight
                    )
                }
                Button(
                    onClick = navigateToRegister,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "New Paw Here?",
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight
                    )
                }
            }
        }
    }
}