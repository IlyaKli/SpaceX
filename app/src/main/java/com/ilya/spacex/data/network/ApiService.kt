package com.ilya.spacex.data.network

import com.ilya.spacex.data.network.model.rocket.RocketDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("rockets")
    suspend fun rocketInfoLoad() : List<RocketDto>

//    @GET("launches")
//    fun launchInfoLoad() :
}