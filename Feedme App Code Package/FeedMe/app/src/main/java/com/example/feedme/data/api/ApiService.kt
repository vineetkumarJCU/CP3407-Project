package com.example.feedme.data.api

import com.example.feedme.data.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("restaurants")
    fun getRestaurants(): Call<List<Restaurant>>
}