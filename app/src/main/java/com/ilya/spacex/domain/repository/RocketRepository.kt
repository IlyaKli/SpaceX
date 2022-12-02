package com.ilya.spacex.domain.repository

import com.ilya.spacex.data.network.model.launch.LaunchDto
import com.ilya.spacex.domain.model.Rocket

interface RocketRepository {

    suspend fun loadRocketInfo() : List<Rocket>

    suspend fun loadRocketLaunchesInfo(rocketId: String) : List<LaunchDto>

//    fun saveSettings()
//
//    fun loadSettings()
}