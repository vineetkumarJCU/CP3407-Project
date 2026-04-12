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
import com.example.feedme.data.model.Restaurant
import com.example.feedme.ui.components.FeedMeTopBar

@Composable
fun SavedScreen(navController: NavController) {
    val savedRestaurants = AppState.savedRestaurants

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Saved",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Button(
                onClick = {
                    navController.navigate("restaurants")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Browse Restaurants")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (savedRestaurants.isEmpty()) {
                Text(
                    "❤️ No saved restaurants yet.",
                    style = MaterialTheme.typography.titleMedium
                )
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(savedRestaurants) { restaurant ->
                        SavedRestaurantCard(
                            restaurant = restaurant,
                            onRemoveClick = {
                                AppState.savedRestaurants.remove(restaurant)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SavedRestaurantCard(
    restaurant: Restaurant,
    onRemoveClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("🍽 Cuisine: ${restaurant.cuisine ?: "N/A"}")
            Text(restaurant.description ?: "No description available")
            Text("🚚 Delivery: $${restaurant.delivery_fee ?: 0.0}")
            Text("⭐ ${restaurant.rating ?: 0.0}")
            Text("🌱 Eco Score: 88")

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onRemoveClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Remove")
            }
        }
    }
}