package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

data class RocketDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("height")
    val height: RocketHeightDto,

    @SerializedName("diameter")
    val diameter: RocketDiameterDto,

    @SerializedName("mass")
    val mass: RocketMassDto,

    @SerializedName("name")
    val payloadWeight: RocketPayloadWeightDto,

    @SerializedName("first_flight")
    val firstFlight: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("cost_per_launch")
    val costLaunch: Int,

    @SerializedName("first_stage")
    val firstStage: RocketFirstStageDto,

    @SerializedName("second_stage")
    val secondStage: RocketSecondStageDto
)