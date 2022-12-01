package com.ilya.spacex.presentation.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ilya.spacex.R
import com.ilya.spacex.databinding.RocketItemBinding
import com.ilya.spacex.domain.model.Rocket

class RocketViewPagerAdapter(private val context: Context) : RecyclerView.Adapter<RocketViewHolder>() {

    var loadingImageListener: (() -> Unit)? = null

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
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean,
                        ): Boolean {
                            return false
                        }
                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean,
                        ): Boolean {
                            loadingImageListener?.invoke()
                            return false
                        }
                    })
                    .into(holder.binding.rocketImageView)
                rocketNameTextView.text = name
                rocketHeightValueTextView.text = height.meters.toString()
                rocketHeightTextView.text = String.format(context.getString(R.string.rocket_height), "m")
                rocketDiameterValueTextView.text = diameter.meters.toString()
                rocketDiameterTextView.text = String.format(context.getString(R.string.rocket_diameter), "m")
                rocketMassValueTextView.text = mass.kilograms.toString()
                rocketMassTextView.text = String.format(context.getString(R.string.rocket_weight), "кг")
                rocketPayloadValueTextView.text = payloadWeight[0].kilograms.toString()
                rocketPayloadTextView.text = String.format(context.getString(R.string.rocket_load), "кг")
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
