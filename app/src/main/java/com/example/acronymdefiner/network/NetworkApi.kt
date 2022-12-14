package com.example.acronymdefiner.network

import com.example.acronymdefiner.model.Definitions
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("/software/acromine/dictionary.py")
    suspend fun fetchDefinitions(@Query("sf") sf: String): Definitions
}