package com.ilya.spacex.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ilya.spacex.data.mapper.RocketMapper
import com.ilya.spacex.data.network.ApiFactory
import com.ilya.spacex.data.network.model.rocket.RocketDto
import com.ilya.spacex.data.network.model.rocket.RocketResponseDto
import com.ilya.spacex.domain.model.RocketResponse
import com.ilya.spacex.domain.repository.RocketRepository
import retrofit2.Call

class RocketRepositoryImpl : RocketRepository {

    val apiService = ApiFactory.apiService
    val mapper = RocketMapper()


    override suspend fun loadRocketInfo(): List<RocketDto> {
        return apiService.rocketInfoLoad()
    }
}