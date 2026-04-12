package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.data.AppState
import com.example.feedme.data.model.PlaceOrder
import com.example.feedme.ui.components.FeedMeTopBar

@Composable
fun CheckoutScreen(
    navController: NavController,
    totalAmount: Double,
    address: String,
    onPlaceOrder: () -> Unit,
    onEditAddress: () -> Unit
) {
    var customerName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        FeedMeTopBar(
            title = "Checkout",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "💳 Checkout",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = customerName,
                onValueChange = { customerName = it },
                label = { Text("Customer Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Delivery Address",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = address,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = onEditAddress) {
                Text("Edit Address")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "🧾 Order Summary",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Total: $${"%.2f".format(totalAmount)}",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    AppState.orders.add(
                        PlaceOrder(
                            restaurantName = "FeedMe Order",
                            customerName = customerName.ifBlank { "Guest" },
                            address = address,
                            phone = phone.ifBlank { "N/A" },
                            status = "Placed"
                        )
                    )
                    onPlaceOrder()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Place Order")
            }
        }
    }
}