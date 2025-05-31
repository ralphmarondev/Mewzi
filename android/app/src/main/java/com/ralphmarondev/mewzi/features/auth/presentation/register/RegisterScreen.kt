package com.ralphmarondev.mewzi.features.auth.presentation.register

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ralphmarondev.mewzi.core.presentation.KeyboardAwareSnackbarHost
import com.ralphmarondev.mewzi.core.util.LocalThemeState
import com.ralphmarondev.mewzi.core.util.StatusBarStyle
import com.ralphmarondev.mewzi.features.auth.presentation.components.NormalTextField
import com.ralphmarondev.mewzi.features.auth.presentation.components.PasswordTextField
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit
) {
    val viewModel: RegisterViewModel = koinViewModel()
    val firstName = viewModel.firstName.collectAsState().value
    val lastName = viewModel.lastName.collectAsState().value
    val username = viewModel.username.collectAsState().value
    val password = viewModel.password.collectAsState().value
    val response = viewModel.response.collectAsState().value

    val themeState = LocalThemeState.current
    val focusManager = LocalFocusManager.current
    val snackbarState = remember { SnackbarHostState() }

    val darkTheme = isSystemInDarkTheme()
    StatusBarStyle(darkTheme)

    LaunchedEffect(response) {
        response?.let {
            if (it.success) {
                navigateToHome()
            } else {
                snackbarState.showSnackbar(it.message)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Register"
                    )
                },
                actions = {
                    IconButton(
                        onClick = themeState::toggleTheme
                    ) {
                        val imageVector = if (themeState.darkTheme.value) {
                            Icons.Outlined.LightMode
                        } else {
                            Icons.Outlined.DarkMode
                        }
                        Icon(
                            imageVector = imageVector,
                            contentDescription = "Theme switcher"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        snackbarHost = {
            KeyboardAwareSnackbarHost(snackbarState)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Create Account",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = "Create an account to post meows. ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(start = 4.dp)
                )
                NormalTextField(
                    value = firstName,
                    onValueChange = viewModel::onFirstNameValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    label = "First name",
                    leadingIcon = Icons.Outlined.AccountCircle,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    )
                )
                NormalTextField(
                    value = lastName,
                    onValueChange = viewModel::onLastNameValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    label = "Last name",
                    leadingIcon = Icons.Outlined.AccountTree,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    )
                )
                NormalTextField(
                    value = username,
                    onValueChange = viewModel::onUsernameValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    label = "Username",
                    leadingIcon = Icons.Outlined.AccountBox,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    )
                )
                PasswordTextField(
                    value = password,
                    onValueChange = viewModel::onPasswordValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    label = "Password",
                    leadingIcon = Icons.Outlined.Password,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.register()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "REGISTER",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    )
                }
                OutlinedButton(
                    onClick = navigateToLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "ALREADY HAVE AN ACCOUNT",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}