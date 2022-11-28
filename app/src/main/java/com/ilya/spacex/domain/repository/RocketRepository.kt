package com.ilya.spacex.domain.repository

import androidx.lifecycle.LiveData
import com.ilya.spacex.data.network.model.rocket.RocketDto
import com.ilya.spacex.data.network.model.rocket.RocketResponseDto
import com.ilya.spacex.domain.model.RocketResponse
import retrofit2.Call

interface RocketRepository {

    suspend fun loadRocketInfo() : List<RocketDto>

//    fun loadRocketLaunchesInfo()

//    fun saveSettings()
//
//    fun loadSettings()
}