package com.example.feedme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.example.feedme.data.FeedMeSettings
import com.example.feedme.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorScheme = if (FeedMeSettings.darkMode) {
                darkColorScheme(
                    primary = FeedMeSettings.accentColor,
                    secondary = FeedMeSettings.accentColor,
                    background = Color(0xFF121212),
                    surface = Color(0xFF1E1E1E)
                )
            } else {
                lightColorScheme(
                    primary = FeedMeSettings.accentColor,
                    secondary = FeedMeSettings.accentColor,
                    background = Color(0xFFF6F6F6),
                    surface = Color.White
                )
            }

            MaterialTheme(
                colorScheme = colorScheme
            ) {
                AppNavigation()
            }
        }
    }
}