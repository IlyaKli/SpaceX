package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

class RocketSecondStageDto(

    @SerializedName("engines")
    val engineCount: Int,

    @SerializedName("fuel_amount_tons")
    val fuelAmount: Double,

    @SerializedName("burn_time_sec")
    val burnTime: Int
)