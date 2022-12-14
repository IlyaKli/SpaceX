package com.ilya.spacex.domain.usecase

import com.ilya.spacex.domain.repository.RocketRepository

class LoadRocketInfoUseCase(private val repository: RocketRepository) {

    suspend operator fun invoke() = repository.loadRocketInfo()
}