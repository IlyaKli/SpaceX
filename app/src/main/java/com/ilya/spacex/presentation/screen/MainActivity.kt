package com.ilya.spacex.presentation.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilya.spacex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}