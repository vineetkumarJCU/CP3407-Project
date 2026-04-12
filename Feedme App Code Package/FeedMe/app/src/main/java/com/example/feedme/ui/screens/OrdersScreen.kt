package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.data.AppState
import com.example.feedme.data.model.PlaceOrder
import com.example.feedme.ui.components.FeedMeTopBar

@Composable
fun OrdersScreen(navController: NavController) {
    val orders = AppState.orders

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Orders",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            if (orders.isEmpty()) {
                Text(
                    "📭 No orders yet.",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate("restaurants")
                    }
                ) {
                    Text("Browse Restaurants")
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(orders) { order ->
                        OrderCard(order)
                    }
                }
            }
        }
    }
}

@Composable
private fun OrderCard(order: PlaceOrder) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                order.restaurantName,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("👤 Customer: ${order.customerName}")
            Text("📍 Address: ${order.address}")
            Text("📞 Phone: ${order.phone}")
            Text("📦 Status: ${order.status}")
        }
    }
}