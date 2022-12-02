package com.ilya.spacex.data.network.model.rocket

import com.google.gson.annotations.SerializedName

data class RocketDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("height")
    val height: RocketHeightDto,

    @SerializedName("diameter")
    val diameter: RocketDiameterDto,

    @SerializedName("mass")
    val mass: RocketMassDto,

    @SerializedName("payload_weights")
    val payloadWeight: List<RocketPayloadWeightDto>,

    @SerializedName("flickr_images")
    val rocketImages: List<String>,

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