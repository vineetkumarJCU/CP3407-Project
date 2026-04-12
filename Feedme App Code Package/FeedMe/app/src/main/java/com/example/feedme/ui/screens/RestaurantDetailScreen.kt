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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RestaurantDetailScreen(navController: NavController) {
    val bg = Color(0xFFF3F4F8)
    val panel = Color.White
    val orange = Color(0xFFF4A048)
    val green = Color(0xFF2FC45A)

    var orderPlaced by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .safeDrawingPadding()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Restaurant Details",
            style = MaterialTheme.typography.headlineMedium,
            color = orange
        )

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
                    text = "🍽 Menu Preview",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Classic meal combos, drinks, and sides will appear here.")

                Spacer(modifier = Modifier.height(20.dp))

                if (!orderPlaced) {
                    Button(
                        onClick = { orderPlaced = true },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = orange),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Place Order")
                    }
                } else {
                    Text("✅ Order placed successfully!")

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = false }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = green),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Go Home")
                    }
                }
            }
        }

        TextButton(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}