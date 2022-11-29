package com.ilya.spacex.domain.repository

import com.ilya.spacex.domain.model.Rocket

interface RocketRepository {

    suspend fun loadRocketInfo() : List<Rocket>

//    fun loadRocketLaunchesInfo()

//    fun saveSettings()
//
//    fun loadSettings()
}