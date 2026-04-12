package com.example.feedme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    val bgColor = Color(0xFFF3F4F8)
    val panel = Color.White
    val orange = Color(0xFFF4A048)
    val darkText = Color(0xFF202020)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .safeDrawingPadding()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "FeedMe",
                style = MaterialTheme.typography.headlineLarge,
                color = orange,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Food ordering made simple",
                color = Color.Gray
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = panel)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.headlineMedium,
                    color = darkText,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sign in to browse restaurants, place orders, and track deliveries.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = orange),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Login")
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { navController.navigate("register") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2FC45A)),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Register")
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(onClick = { navController.navigate("home") }) {
                    Text("Continue as Demo")
                }
            }
        }

        Text(
            text = "Fast delivery • Transparent pricing • Local restaurants",
            color = Color.Gray
        )
    }
}