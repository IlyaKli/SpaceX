package com.ilya.spacex.data.network.model.rocket

class RocketDto(
    val name: String,
    val height: RocketHeightDto,
    val diameter: RocketDiameterDto,
    val mass: RocketMassDto,
    val payloadWeight: RocketPayloadWeightDto,
    val firstFlight: String,
    val country: String,
    val costLaunch: Int,
    val firstStage: RocketFirstStageDto,
    val stage: RocketSecondStageDto
)