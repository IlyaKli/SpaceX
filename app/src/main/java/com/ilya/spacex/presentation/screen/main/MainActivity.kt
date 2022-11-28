package com.ilya.spacex.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.ilya.spacex.data.repository.RocketRepositoryImpl
import com.ilya.spacex.databinding.ActivityMainBinding
import com.ilya.spacex.domain.model.*
import com.ilya.spacex.domain.usecase.LoadRocketInfoUseCase
import com.ilya.spacex.presentation.adapter.RocketViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RocketViewPagerAdapter(this)}
    private val viewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainViewPager.adapter = adapter
        val v = viewModel
//        viewModel.rockets.observe(this) {
//            adapter.rockets = it.rocketList
//        }

//        for (i in 0..3) {
//            val rocket = Rocket(
//                "Heavy",
//                RocketHeight(200.0, 300.0),
//                RocketDiameter(250.0, 350.0),
//                RocketMass(35, 57),
//                RocketPayloadWeight(24, 87),
//                "14 fev",
//                "usa",
//                6876812,
//                RocketFirstStage(45, 456.89,456),
//                RocketSecondStage(46, 856.89,496)
//            )
//            rockets.add(rocket)
//        }
//
//        adapter.rockets = rockets
    }
}