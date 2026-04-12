package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.ui.components.FeedMeTopBar

data class MenuItem(
    val name: String,
    val price: Double
)

@Composable
fun VendorAnalyticsScreen(navController: NavController) {

    var menuItems by remember {
        mutableStateOf(
            listOf(
                MenuItem("Burger Combo", 18.99),
                MenuItem("Fries", 5.99)
            )
        )
    }

    var newItemName by remember { mutableStateOf("") }
    var newItemPrice by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Vendor Dashboard",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // 📊 Analytics
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("📊 Total Orders: 128")
                    Text("💰 Revenue: $2,430")
                    Text("🔥 Top Item: Burger Combo")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🍔 Menu management
            Text(
                "🍔 Menu Management",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = newItemName,
                onValueChange = { newItemName = it },
                label = { Text("Item Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = newItemPrice,
                onValueChange = { newItemPrice = it },
                label = { Text("Price") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (newItemName.isNotBlank() && newItemPrice.isNotBlank()) {
                        menuItems = menuItems + MenuItem(
                            newItemName,
                            newItemPrice.toDoubleOrNull() ?: 0.0
                        )
                        newItemName = ""
                        newItemPrice = ""
                    }
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Add Item")
            }

            LazyColumn {
                items(menuItems) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(item.name)
                                Text("$${item.price}")
                            }

                            TextButton(
                                onClick = {
                                    menuItems = menuItems.filter { it != item }
                                }
                            ) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}