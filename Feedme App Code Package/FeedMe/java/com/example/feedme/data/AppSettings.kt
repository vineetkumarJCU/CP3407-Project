package com.example.feedme.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object FeedMeSettings {
    var darkMode by mutableStateOf(false)
    var username by mutableStateOf("Charlotte W")
    var accentColor by mutableStateOf(Color(0xFFF4A048))

    fun setOrangeTheme() {
        accentColor = Color(0xFFF4A048)
    }

    fun setBlueTheme() {
        accentColor = Color(0xFF4A90E2)
    }

    fun setPurpleTheme() {
        accentColor = Color(0xFF9B59B6)
    }

    fun setGreenTheme() {
        accentColor = Color(0xFF2FC45A)
    }

    fun reset() {
        darkMode = false
        username = "Charlotte W"
        setOrangeTheme()
    }
}