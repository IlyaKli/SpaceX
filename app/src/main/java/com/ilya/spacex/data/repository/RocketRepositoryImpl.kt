package com.ilya.spacex.data.repository

import android.util.Log
import com.ilya.spacex.data.mapper.RocketMapper
import com.ilya.spacex.data.network.ApiFactory
import com.ilya.spacex.data.network.model.launch.LaunchDto
import com.ilya.spacex.data.network.model.rocket.RocketDto
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.domain.repository.RocketRepository
import retrofit2.Call

class RocketRepositoryImpl : RocketRepository {

    val apiService = ApiFactory.apiService
    val mapper = RocketMapper()


    override suspend fun loadRocketInfo(): List<Rocket> {
        return mapper.mapRocketListDtoToEntity(apiService.rocketInfoLoad())
    }

    override suspend fun loadRocketLaunchesInfo(rocketId: String): List<LaunchDto> {
        return apiService.launchesInfoLoad().filter { it.rocketId ==  rocketId}
    }
}