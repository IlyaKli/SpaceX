package com.ilya.spacex.presentation.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.spacex.data.network.model.rocket.RocketDto
import com.ilya.spacex.data.repository.RocketRepositoryImpl
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.domain.usecase.LoadRocketInfoUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {

    val repository = RocketRepositoryImpl()

    var rockets = MutableLiveData<List<Rocket>>()

    val loadRocketInfoUseCase = LoadRocketInfoUseCase(repository)

    init {
        loadRocketInfo()
    }

    fun loadRocketInfo() {
        viewModelScope.launch {
            rockets.value = loadRocketInfoUseCase()
        }
    }
}