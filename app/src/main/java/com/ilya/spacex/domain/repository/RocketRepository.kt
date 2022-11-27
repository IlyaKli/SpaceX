package com.ilya.spacex.domain.repository

interface RocketRepository {

    fun loadRocketInfo()

    fun loadRocketLaunchesInfo()

    fun saveSettings()

    fun loadSettings()
}