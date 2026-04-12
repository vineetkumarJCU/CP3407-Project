package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.ui.components.FeedMeTopBar
import kotlinx.coroutines.delay

@Composable
fun OrderTrackingScreen(navController: NavController) {
    val steps = listOf(
        "Order Placed ✅",
        "Preparing 🍳",
        "Out for Delivery 🚗",
        "Delivered 🎉"
    )

    var currentStep by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (currentStep < steps.lastIndex) {
            delay(2000)
            currentStep++
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Order Tracking",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "📦 Live Order Tracking",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Estimated arrival: 12–18 mins",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            steps.forEachIndexed { index, step ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = if (index <= currentStep)
                        CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    else
                        CardDefaults.cardColors()
                ) {
                    Text(
                        text = step,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (currentStep == steps.lastIndex) {
                Text(
                    "🎉 Your order has arrived!",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}