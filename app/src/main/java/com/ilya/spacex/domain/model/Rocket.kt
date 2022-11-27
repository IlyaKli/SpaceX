package com.ilya.spacex.domain.model

class Rocket(
    val name: String,
    val height: RocketHeight,
    val diameter: RocketDiameter,
    val mass: RocketMass,
    val payloadWeight: RocketPayloadWeight,
    val firstFlight: String,
    val country: String,
    val costLaunch: String,
    val firstStage: RocketFirstStage,
    val stage: RocketSecondStage
)