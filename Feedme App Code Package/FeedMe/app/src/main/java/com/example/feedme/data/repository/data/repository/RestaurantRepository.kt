package com.example.feedme.data.repository

import com.example.feedme.data.api.RetrofitClient
import com.example.feedme.data.model.Restaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestaurantRepository {

    fun getRestaurants(onResult: (List<Restaurant>) -> Unit) {
        RetrofitClient.apiService.getRestaurants()
            .enqueue(object : Callback<List<Restaurant>> {

                override fun onResponse(
                    call: Call<List<Restaurant>>,
                    response: Response<List<Restaurant>>
                ) {
                    onResult(response.body() ?: emptyList())
                }

                override fun onFailure(
                    call: Call<List<Restaurant>>,
                    t: Throwable
                ) {
                    onResult(emptyList())
                }
            })
    }
}