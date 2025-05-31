package com.ralphmarondev.mewzi.features.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Drafts
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.mewzi.R
import com.ralphmarondev.mewzi.core.di.BASE_URL
import com.ralphmarondev.mewzi.features.profile.presentation.components.OptionCard
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val viewModel: ProfileViewModel = koinViewModel()
    val user = viewModel.user.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                val profileImage = if (user?.image.isNullOrBlank()) {
                    R.drawable.profile
                } else {
                    "$BASE_URL${user?.image}"
                }
                Box(modifier = Modifier.size(120.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(profileImage),
                        contentDescription = "Profile image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .border(
                                2.dp,
                                MaterialTheme.colorScheme.primary,
                                CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                    )

                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = (-6).dp, y = (-6).dp)
                            .clip(CircleShape)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.CameraAlt,
                            contentDescription = "Update profile image",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${user?.firstName} ${user?.lastName}",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "${user?.username}",
                    fontSize = 14.sp,
                    fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
                    color = MaterialTheme.colorScheme.secondary
                )
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                OptionCard(
                    onClick = {},
                    leadingIcon = Icons.Outlined.MonetizationOn,
                    trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos,
                    text = "Mewzi Coins",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
                OptionCard(
                    onClick = {},
                    leadingIcon = Icons.Outlined.Drafts,
                    trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos,
                    text = "Drafts",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
                OptionCard(
                    onClick = {},
                    leadingIcon = Icons.Outlined.History,
                    trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos,
                    text = "History",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
                OptionCard(
                    onClick = {},
                    leadingIcon = Icons.AutoMirrored.Outlined.Logout,
                    trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos,
                    text = "Logout",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}