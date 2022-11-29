package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

class RocketPayloadWeightDto(
    @SerializedName("kg")
    val kilograms: Int,

    @SerializedName("lb")
    val pounds: Int
)