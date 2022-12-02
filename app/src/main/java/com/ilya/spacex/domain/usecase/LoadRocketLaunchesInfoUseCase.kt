package com.ilya.spacex.domain.usecase

import com.ilya.spacex.domain.repository.RocketRepository

class LoadRocketLaunchesInfoUseCase(private val repository: RocketRepository) {
    suspend operator fun invoke(rocketId: String) = repository.loadRocketLaunchesInfo(rocketId)
}