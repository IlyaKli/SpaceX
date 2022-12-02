package com.ilya.spacex.presentation.screen.launch

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilya.spacex.R
import com.ilya.spacex.databinding.ActivityLaunchBinding
import com.ilya.spacex.databinding.ActivityMainBinding
import com.ilya.spacex.domain.model.Rocket
import com.ilya.spacex.presentation.adapter.LaunchAdapter
import com.ilya.spacex.presentation.adapter.RocketViewPagerAdapter
import com.ilya.spacex.presentation.screen.main.MainActivityViewModel

class LaunchActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLaunchBinding.inflate(layoutInflater) }
    private val adapter by lazy { LaunchAdapter() }
    private val viewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java] }

    val rocketId by lazy { intent.getStringExtra(ROCKET_ID_EXTRA) }
    val rocketName by lazy { intent.getStringExtra(ROCKET_NAME_EXTRA) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rocketNameLaunchTextView.text = rocketName
        binding.launchRecyclerView.adapter = adapter
        binding.launchRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel.loadLaunchInfo(rocketId!!)
        viewModel.launches.observe(this) {
            adapter.submitList(it)
        }
    }


    companion object {
        fun newIntent(rocketId: String, rocketName: String, context: Context): Intent {
            val intent = Intent(context, LaunchActivity::class.java)
            intent.putExtra(ROCKET_ID_EXTRA, rocketId)
            intent.putExtra(ROCKET_NAME_EXTRA, rocketName)
            return intent
        }

        const val ROCKET_ID_EXTRA = "rocket_id"

        const val ROCKET_NAME_EXTRA = "rocket_name"
    }
}