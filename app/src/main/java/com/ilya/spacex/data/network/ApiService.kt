package com.ilya.spacex.data.network

import com.ilya.spacex.data.network.model.rocket.RocketResponseDto
import retrofit2.http.GET

interface ApiService {

    @GET("rockets")
    fun rocketInfoLoad() : RocketResponseDto

//    @GET("launches")
//    fun launchInfoLoad() :
}