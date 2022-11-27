package com.ilya.spacex.domain.usecase

import com.ilya.spacex.domain.repository.RocketRepository

class LoadRocketInfoUseCase(private val repository: RocketRepository) {

    operator fun invoke() = repository.loadRocketInfo()
}