package com.example.feedme.data.model

data class Restaurant(
    val id: Int,
    val name: String,
    val cuisine: String?,
    val description: String?,
    val delivery_fee: Double?,
    val rating: Double?
)