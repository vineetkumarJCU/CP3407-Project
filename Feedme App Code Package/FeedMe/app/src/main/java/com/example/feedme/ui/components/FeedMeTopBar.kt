package com.example.feedme.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedMeTopBar(
    title: String,
    navController: NavController,
    showBack: Boolean = true
) {
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            if (showBack) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("←")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        )
    )
}