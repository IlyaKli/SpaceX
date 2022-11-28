package com.ilya.spacex.presentation.screen.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.spacex.data.network.model.rocket.RocketDto
import com.ilya.spacex.data.network.model.rocket.RocketResponseDto
import com.ilya.spacex.data.repository.RocketRepositoryImpl
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.domain.model.RocketResponse
import com.ilya.spacex.domain.usecase.LoadRocketInfoUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {

    val repository = RocketRepositoryImpl()


    var rockets = mutableListOf<Rocket>()

    val loadRocketInfoUseCase = LoadRocketInfoUseCase(repository)

    var rocketResponse = mutableListOf<RocketDto>()

    init {
        loadRocketInfo()
        Log.d("rocketsasddad", rocketResponse.toString())
    }

    fun loadRocketInfo() {
        viewModelScope.launch {
            rocketResponse = loadRocketInfoUseCase().toMutableList()
        }
    }



}