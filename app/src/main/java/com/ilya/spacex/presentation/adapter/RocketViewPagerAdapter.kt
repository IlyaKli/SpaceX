package com.ilya.spacex.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilya.spacex.databinding.RocketItemBinding
import com.ilya.spacex.domain.model.Rocket

class RocketViewPagerAdapter(private val context: Context) : RecyclerView.Adapter<RocketViewHolder>() {

    var rockets = listOf<Rocket>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val binding = RocketItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RocketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val rocket = rockets[position]
    }

    override fun getItemCount(): Int {
        return rockets.size
    }
}