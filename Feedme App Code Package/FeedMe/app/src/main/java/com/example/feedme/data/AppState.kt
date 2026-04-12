package com.example.feedme.data

import androidx.compose.runtime.mutableStateListOf
import com.example.feedme.data.model.PlaceOrder
import com.example.feedme.data.model.Restaurant

object AppState {
    val orders = mutableStateListOf<PlaceOrder>()
    val savedRestaurants = mutableStateListOf<Restaurant>()
}