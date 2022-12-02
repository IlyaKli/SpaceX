package com.ilya.spacex.data.network

import com.ilya.spacex.data.network.model.launch.LaunchDto
import com.ilya.spacex.data.network.model.rocket.RocketDto
import retrofit2.http.*

interface ApiService {

    @GET("rockets")
    suspend fun rocketInfoLoad() : List<RocketDto>

    @GET("launches")
    suspend fun launchesInfoLoad() : List<LaunchDto>
}