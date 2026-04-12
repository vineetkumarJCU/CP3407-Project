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
fun RestaurantListScreen(navController: NavController) {

    val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Macca's",
            cuisine = "Fast Food",
            description = "Burgers, fries, and drinks",
            delivery_fee = 3.99,
            rating = 4.8
        ),
        Restaurant(
            id = 2,
            name = "Pizza Hut",
            cuisine = "Pizza",
            description = "Pizza, pasta, and sides",
            delivery_fee = 4.99,
            rating = 4.5
        ),
        Restaurant(
            id = 3,
            name = "Sushi Hub",
            cuisine = "Japanese",
            description = "Fresh sushi and rolls",
            delivery_fee = 5.49,
            rating = 4.9
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {

        FeedMeTopBar(
            title = "Explore",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "🍽 Explore Restaurants",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(restaurants) { restaurant ->
                    RestaurantListCard(
                        restaurant = restaurant,
                        onViewClick = {
                            navController.navigate("restaurant_detail")
                        },
                        onSaveClick = {
                            if (!AppState.savedRestaurants.contains(restaurant)) {
                                AppState.savedRestaurants.add(restaurant)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun RestaurantListCard(
    restaurant: Restaurant,
    onViewClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                restaurant.name,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("🍽 ${restaurant.cuisine ?: "Cuisine"}")
            Text(restaurant.description ?: "No description available")
            Text("⭐ ${restaurant.rating ?: 0.0}")
            Text("🚚 Delivery: $${restaurant.delivery_fee ?: 0.0}")
            Text("🌱 Eco Score: 88")

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onViewClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("View Details")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onSaveClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Restaurant")
            }
        }
    }
}