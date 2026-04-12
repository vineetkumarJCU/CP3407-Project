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

data class Vendor(
    val name: String,
    var status: String
)

@Composable
fun AdminApprovalScreen(navController: NavController) {

    var vendors by remember {
        mutableStateOf(
            listOf(
                Vendor("Burger House", "Pending"),
                Vendor("Pizza Corner", "Pending"),
                Vendor("Sushi Hub", "Pending")
            )
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        // ✅ Universal top bar
        FeedMeTopBar(
            title = "Admin Panel",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                "🛡 Vendor Approval Queue",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(vendors) { vendor ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                vendor.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text("Status: ${vendor.status}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Row {
                                Button(
                                    onClick = {
                                        vendors = vendors.map {
                                            if (it == vendor) {
                                                it.copy(status = "Approved")
                                            } else it
                                        }
                                    }
                                ) {
                                    Text("Approve")
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                OutlinedButton(
                                    onClick = {
                                        vendors = vendors.map {
                                            if (it == vendor) {
                                                it.copy(status = "Rejected")
                                            } else it
                                        }
                                    }
                                ) {
                                    Text("Reject")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}