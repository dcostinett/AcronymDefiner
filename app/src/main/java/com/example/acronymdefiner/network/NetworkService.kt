package com.example.acronymdefiner.network

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    private val retrofit: Retrofit = Builder()
        .baseUrl("http://www.nactem.ac.uk")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(NetworkApi::class.java)
}