package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

class RocketHeightDto(
    @SerializedName("meters")
    val meters: Double,

    @SerializedName("feet")
    val feet: Double
)