package com.ilya.spacex.domain.model

data class Rocket(
    val id: String,

    val name: String,

    val height: RocketHeight,

    val diameter: RocketDiameter,

    val mass: RocketMass,

    val payloadWeight: List<RocketPayloadWeight>,

    val rocketImages: List<String>,

    val firstFlight: String,

    val country: String,

    val costLaunch: Int,

    val firstStage: RocketFirstStage,

    val secondStage: RocketSecondStage
)