package com.example.feedme.data.model

data class PlaceOrder(
    val restaurantName: String,
    val customerName: String,
    val address: String,
    val phone: String,
    val status: String = "Placed"
)