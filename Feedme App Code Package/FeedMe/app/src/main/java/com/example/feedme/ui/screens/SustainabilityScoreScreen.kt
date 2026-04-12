package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.ui.components.FeedMeTopBar

@Composable
fun SustainabilityScoreScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Eco Score",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                "🌱 Sustainability Score",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Eco Packaging: 92%")
                    Text("Local Ingredients: 85%")
                    Text("Carbon Footprint: Low")
                    Text("Green Badge: ⭐ Gold")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LinearProgressIndicator(
                progress = { 0.88f },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Overall Score: 88/100",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ✅ acceptance criteria explanation
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("📘 Score Guide")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("90–100 = Excellent")
                    Text("75–89 = Good")
                    Text("50–74 = Average")
                    Text("Below 50 = Poor")
                }
            }
        }
    }
}