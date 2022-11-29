package com.ilya.spacex.domain.model

import com.google.gson.annotations.SerializedName

class RocketFirstStage(

    val engineCount: Int,

    val fuelAmount: Double,

    val burnTime: Int
)