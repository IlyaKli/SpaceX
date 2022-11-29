package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

data class RocketDiameterDto(
    @SerializedName("meters")
    val meters: Double,

    @SerializedName("feet")
    val feet: Double
)