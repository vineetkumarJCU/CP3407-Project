package com.example.feedme.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.data.FeedMeSettings

data class HomeRestaurant(
    val name: String,
    val subtitle: String,
    val priceHint: String,
    val rating: String,
    val emoji: String
)

@Composable
fun HomeScreen(navController: NavController) {
    val darkMode = FeedMeSettings.darkMode
    val accent = FeedMeSettings.accentColor

    val bg = if (darkMode) Color(0xFF111111) else Color(0xFFF3F4F8)
    val panel = if (darkMode) Color(0xFF1B1B1B) else Color.White
    val cardBg = if (darkMode) Color(0xFF1E1E1E) else Color.White
    val mutedCard = if (darkMode) Color(0xFF232323) else Color(0xFFF7DFC2)
    val textPrimary = if (darkMode) Color.White else Color(0xFF151515)
    val textSecondary = if (darkMode) Color(0xFFB8B8B8) else Color(0xFF6A6A6A)

    var searchText by rememberSaveable { mutableStateOf("") }
    var deliveryAddress by rememberSaveable { mutableStateOf("Enter delivery address") }
    var showAddressDialog by remember { mutableStateOf(false) }
    var tempAddress by rememberSaveable { mutableStateOf("") }

    val featured = listOf(
        HomeRestaurant("Macca's", "Burgers • Fries • Drinks", "$$", "4.8", "🍔"),
        HomeRestaurant("Pizza Hut", "Pizza • Pasta • Sides", "$$", "4.3", "🍕"),
        HomeRestaurant("Hog's Breath", "Steak • Grill", "$$$", "3.8", "🥩")
    )

    val recent = listOf(
        HomeRestaurant("KFC", "Chicken • Burgers", "$$", "4.7", "🍗"),
        HomeRestaurant("Subway", "Subs • Wraps", "$$", "4.6", "🥪")
    )

    val recommended = listOf(
        HomeRestaurant("Gelato Land", "Dessert • Ice Cream", "$$", "4.9", "🍨"),
        HomeRestaurant("Sushi Hub", "Japanese • Sushi", "$$$", "4.8", "🍣")
    )

    if (showAddressDialog) {
        AlertDialog(
            onDismissRequest = { showAddressDialog = false },
            title = { Text("Delivery Address") },
            text = {
                OutlinedTextField(
                    value = tempAddress,
                    onValueChange = { tempAddress = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words
                    )
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    deliveryAddress = tempAddress.ifBlank { "Enter delivery address" }
                    showAddressDialog = false
                }) { Text("Save") }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .safeDrawingPadding()
    ) {
        TopBar(accent, searchText) { searchText = it }

        Row(modifier = Modifier.fillMaxSize().padding(12.dp)) {
            SideMenu(
                modifier = Modifier.width(118.dp),
                mutedCard = mutedCard,
                accent = accent,
                navController = navController,
                textPrimary = textPrimary,
                textSecondary = textSecondary,
                panel = panel
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                HeroBanner(
                    deliveryAddress = deliveryAddress,
                    onAddressClick = { showAddressDialog = true }
                )

                Spacer(modifier = Modifier.height(18.dp))

                SectionTitle("Order Again", textPrimary)
                HorizontalRestaurantRow(featured, accent, cardBg, textPrimary, textSecondary) {
                    navController.navigate("checkout/${Uri.encode(it.name)}")
                }

                Spacer(modifier = Modifier.height(22.dp))

                SectionTitle("Recently Viewed", textPrimary)
                HorizontalRestaurantRow(recent, accent, cardBg, textPrimary, textSecondary) {
                    navController.navigate("checkout/${Uri.encode(it.name)}")
                }

                Spacer(modifier = Modifier.height(22.dp))

                SectionTitle("Recommended For You", textPrimary)
                HorizontalRestaurantRow(recommended, accent, cardBg, textPrimary, textSecondary) {
                    navController.navigate("checkout/${Uri.encode(it.name)}")
                }
            }
        }
    }
}

@Composable
private fun TopBar(accent: Color, searchText: String, onSearchChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(accent)
            .padding(12.dp)
    ) {
        Text("FeedMe", color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(12.dp))
        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchChange,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun SideMenu(
    modifier: Modifier,
    mutedCard: Color,
    accent: Color,
    navController: NavController,
    textPrimary: Color,
    textSecondary: Color,
    panel: Color
) {
    Column(modifier = modifier) {
        Card(colors = CardDefaults.cardColors(containerColor = mutedCard)) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("New Deals", color = textPrimary, fontWeight = FontWeight.Bold)
                Text("Latest food promotions", color = textSecondary)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        MenuButton("Explore") { navController.navigate("restaurants") }
        MenuButton("Saved") { navController.navigate("saved") }
        MenuButton("Orders") { navController.navigate("orders") }
        MenuButton("Vendor") { navController.navigate("vendor_analytics") }
        MenuButton("Admin") { navController.navigate("admin_approval") }
        MenuButton("Eco Score") { navController.navigate("sustainability") }
        MenuButton("Settings") { navController.navigate("settings") }
    }
}

@Composable
private fun MenuButton(label: String, onClick: () -> Unit) {
    Spacer(modifier = Modifier.height(8.dp))
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(label)
    }
}

@Composable
private fun HeroBanner(deliveryAddress: String, onAddressClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Food that flies to your door", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "📍 $deliveryAddress",
                modifier = Modifier.clickable { onAddressClick() }
            )
        }
    }
}

@Composable
private fun SectionTitle(title: String, textPrimary: Color) {
    Text(title, color = textPrimary, style = MaterialTheme.typography.headlineSmall)
}

@Composable
private fun HorizontalRestaurantRow(
    restaurants: List<HomeRestaurant>,
    accent: Color,
    cardBg: Color,
    textPrimary: Color,
    textSecondary: Color,
    onOrderClick: (HomeRestaurant) -> Unit
) {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        restaurants.forEach { restaurant ->
            RestaurantCard(
                restaurant,
                accent,
                cardBg,
                textPrimary,
                textSecondary
            ) {
                onOrderClick(restaurant)
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Composable
private fun RestaurantCard(
    restaurant: HomeRestaurant,
    accent: Color,
    cardBg: Color,
    textPrimary: Color,
    textSecondary: Color,
    onOrderClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardBg),
        modifier = Modifier.width(220.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(restaurant.emoji)
            Text(restaurant.name, color = textPrimary, fontWeight = FontWeight.Bold)
            Text(restaurant.subtitle, color = textSecondary)
            Text("⭐ ${restaurant.rating} • ${restaurant.priceHint}")
            Text("🌱 Eco Score: 88")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onOrderClick,
                colors = ButtonDefaults.buttonColors(containerColor = accent)
            ) {
                Text("Order")
            }
        }
    }
}