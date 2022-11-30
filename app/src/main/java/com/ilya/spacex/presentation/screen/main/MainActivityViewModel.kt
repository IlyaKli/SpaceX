package com.ilya.spacex.presentation.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.spacex.data.repository.RocketRepositoryImpl
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.domain.usecase.LoadRocketInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel() : ViewModel() {

    private val repository = RocketRepositoryImpl()

    private val loadRocketInfoUseCase = LoadRocketInfoUseCase(repository)

    private val _rockets = MutableLiveData<List<Rocket>>()
    val rockets: LiveData<List<Rocket>>
        get() = _rockets

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        loadRocketInfo()

    }

    private fun loadRocketInfo() {
        _isLoading.value = true
        viewModelScope.launch {
            _rockets.value = loadRocketInfoUseCase()
            withContext(Dispatchers.Main) {
                _isLoading.value = false
            }
        }
    }
}