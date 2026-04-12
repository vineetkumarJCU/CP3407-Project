package com.example.feedme.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class CartItem(val name: String, val price: Double, var quantity: Int)

@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onCheckoutClick: () -> Unit
) {
    var total by remember { mutableStateOf(0.0) }

    LaunchedEffect(cartItems) {
        total = cartItems.sumOf { it.price * it.quantity }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("🛒 Your Cart", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems) { item ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(item.name)
                        Text("Price: $${item.price}")
                        Text("Qty: ${item.quantity}")
                    }
                }
            }
        }

        Text("Total: $${"%.2f".format(total)}", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onCheckoutClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Proceed to Checkout")
        }
    }
}