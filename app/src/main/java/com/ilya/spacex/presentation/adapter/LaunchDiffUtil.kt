package com.ilya.spacex.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ilya.spacex.data.network.model.launch.LaunchDto

class LaunchDiffUtil : DiffUtil.ItemCallback<LaunchDto>() {
    override fun areItemsTheSame(oldItem: LaunchDto, newItem: LaunchDto): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LaunchDto, newItem: LaunchDto): Boolean {
        return oldItem == newItem
    }
}