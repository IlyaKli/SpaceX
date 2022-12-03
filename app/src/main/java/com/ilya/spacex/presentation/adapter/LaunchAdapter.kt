package com.ilya.spacex.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ilya.spacex.R
import com.ilya.spacex.data.network.model.launch.LaunchDto
import com.ilya.spacex.databinding.LaunchItemBinding

class LaunchAdapter : ListAdapter<LaunchDto, LaunchViewHolder>(LaunchDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val binding = LaunchItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = currentList[position]
        holder.binding.nameLaunchTextView.text = launch.name
        if (launch.status == true) {
            holder.binding.statusLaunchImageView.setImageResource(R.drawable.ic_rocket_launch_true)
        } else {
            holder.binding.statusLaunchImageView.setImageResource(R.drawable.ic_rocket_launch_false)
        }
        holder.binding.dateLaunchTextView.text = launch.date
    }
}