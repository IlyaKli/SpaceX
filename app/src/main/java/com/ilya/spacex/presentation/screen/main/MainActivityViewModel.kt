package com.ilya.spacex.presentation.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.spacex.data.network.model.launch.LaunchDto
import com.ilya.spacex.data.repository.RocketRepositoryImpl
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.domain.usecase.LoadRocketInfoUseCase
import com.ilya.spacex.domain.usecase.LoadRocketLaunchesInfoUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {

    private val repository = RocketRepositoryImpl()

    private val loadRocketInfoUseCase = LoadRocketInfoUseCase(repository)

    val loadRocketLaunchesInfoUseCase = LoadRocketLaunchesInfoUseCase(repository)

    private val _launches = MutableLiveData<List<LaunchDto>>()
    val launches: LiveData<List<LaunchDto>>
        get() = _launches

    private val _rockets = MutableLiveData<List<Rocket>>()
    val rockets: LiveData<List<Rocket>>
        get() = _rockets

    init {
        loadRocketInfo()
    }

    private fun loadRocketInfo() {
        viewModelScope.launch {
            _rockets.value = loadRocketInfoUseCase()
        }
    }

    fun loadLaunchInfo(rocketId: String) {
        viewModelScope.launch {
            _launches.value = loadRocketLaunchesInfoUseCase(rocketId)
        }
    }
}