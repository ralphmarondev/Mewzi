package com.ralphmarondev.mewzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.mewzi.navigation.AppNavigation
import com.ralphmarondev.mewzi.ui.theme.MewziTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MewziTheme {
                AppNavigation()
            }
        }
    }
}
