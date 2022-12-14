package com.ilya.spacex.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilya.spacex.data.network.model.rocket.RocketDto
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
        with (holder.binding) {
            with (rocket) {
                Glide.with(holder.binding.rocketImageView)
                    .load(rocket.rocketImages[0])
                    .into(holder.binding.rocketImageView)
                rocketNameTextView.text = name
                rocketHeightValueTextView.text = height.meters.toString()
//                rocketHeightTextView.text =
                rocketDiameterValueTextView.text = diameter.meters.toString()
//                rocketDiameterTextView.text =
                rocketMassValueTextView.text = mass.kilograms.toString()
//                rocketMassTextView.text =
                rocketPayloadValueTextView.text = payloadWeight[0].kilograms.toString()
//                rocketPayloadTextView.text =
                firstFlightTextView.text = firstFlight
                countryTextView.text = country
                costLaunchTextView.text = costLaunch.toString()
                engineCountTextView.text = firstStage.engineCount.toString()
                fuelCountTextView.text = firstStage.fuelAmount.toString()
                burnTimeTextView.text = firstStage.burnTime.toString()
                engineCountSecondTextView.text = secondStage.engineCount.toString()
                fuelCountSecondTextView.text = secondStage.fuelAmount.toString()
                burnTimeSecondTextView.text = secondStage.burnTime.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return rockets.size
    }
}