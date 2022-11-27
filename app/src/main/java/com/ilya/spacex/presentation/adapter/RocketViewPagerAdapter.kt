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
        with (holder.binding) {
            with (rocket) {
//                rocketImageView.setImageResource()
                rocketNameTextView.text = name
                rocketHeightValueTextView.text = height.meters.toString()
//                rocketHeightTextView.text =
                rocketDiameterValueTextView.text = diameter.meters.toString()
//                rocketDiameterTextView.text =
                rocketMassValueTextView.text = mass.kilograms.toString()
//                rocketMassTextView.text =
                rocketPayloadValueTextView.text = mass.kilograms.toString()
//                rocketPayloadTextView.text =
                firstFlightTextView.text = firstFlight
                countryTextView.text = country
                costLaunchTextView.text = costLaunch.toString()
                engineCountTextView.text = firstStage.engines.toString()
                fuelCountTextView.text = firstStage.fuel_amount_tons.toString()
                burnTimeTextView.text = firstStage.burn_time_sec.toString()
                engineCountSecondTextView.text = secondStage.engines.toString()
                fuelCountSecondTextView.text = secondStage.fuel_amount_tons.toString()
                burnTimeSecondTextView.text = secondStage.burn_time_sec.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return rockets.size
    }
}