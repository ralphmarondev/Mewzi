package com.ralphmarondev.mewzi.features.new_post.presentation

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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ralphmarondev.mewzi.core.presentation.KeyboardAwareSnackbarHost
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPostScreen() {
    val viewModel: NewPostViewModel = koinViewModel()
    val caption = viewModel.caption.collectAsState().value
    val response = viewModel.response.collectAsState().value

    val focusManager = LocalFocusManager.current
    val snackbar = remember { SnackbarHostState() }

    LaunchedEffect(response) {
        response?.let {
            if (it.success) {
                snackbar.showSnackbar(it.message)
            } else {
                snackbar.showSnackbar(it.message)
            }
            viewModel.clearResponse()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "New Post"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        snackbarHost = {
            KeyboardAwareSnackbarHost(snackbar)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                OutlinedTextField(
                    value = caption,
                    onValueChange = viewModel::onCaptionValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    placeholder = {
                        Text(
                            text = "What's on your mind?"
                        )
                    },
                    singleLine = false,
                    minLines = 3,
                    maxLines = 3,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = viewModel::post,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "UPLOAD POST",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}