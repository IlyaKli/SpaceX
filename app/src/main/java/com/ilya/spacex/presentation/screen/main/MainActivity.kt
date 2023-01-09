package com.ilya.spacex.presentation.screen.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.ilya.spacex.R
import com.ilya.spacex.databinding.ActivityMainBinding
import com.ilya.spacex.presentation.adapter.RocketViewPagerAdapter
import com.ilya.spacex.presentation.screen.launch.LaunchActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RocketViewPagerAdapter(this)}
    private val viewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java] }
    private val bottomSheet by lazy { BottomSheetBehavior.from(binding.bottomSheet) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainViewPager.adapter = adapter
        binding.mainViewPager.offscreenPageLimit = 4
        viewModel.rockets.observe(this) {
            adapter.rockets = it
        }
        adapter.loadingImageListener = {
            binding.mainViewPager.visibility = View.VISIBLE
            setTheme(R.style.Theme_SpaceX)
        }
        bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
        adapter.settingClickListener = {
            bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
        }
        binding.closeTextView.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
        }
        adapter.launchClickListener = {
            startActivity(LaunchActivity.newIntent(it.id, it.name, this))
        }
    }
}



























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