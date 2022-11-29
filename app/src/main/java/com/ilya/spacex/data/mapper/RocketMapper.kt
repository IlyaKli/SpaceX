package com.ilya.spacex.data.mapper

import com.ilya.spacex.data.network.model.rocket.*
import com.ilya.spacex.domain.model.*

class RocketMapper {

    fun mapRocketListDtoToEntity(list: List<RocketDto>): List<Rocket> {
        return list.map {
            mapRocketDtoToEntity(it)
        }
    }

    private fun mapRocketDtoToEntity(dto: RocketDto) = Rocket(
        name = dto.name,
        height = mapRocketHeightDtoToEntity(dto.height),
        diameter = mapRocketDiameterDtoToEntity(dto.diameter),
        mass = mapRocketMassDtoToEntity(dto.mass),
        payloadWeight = mapPayloadWeightListDtoToEntity(dto.payloadWeight),
        firstFlight = dto.firstFlight,
        country = dto.country,
        costLaunch = dto.costLaunch,
        firstStage = mapRocketFirstStageDtoToEntity(dto.firstStage),
        secondStage = mapRocketSecondStageDtoToEntity(dto.secondStage),
        rocketImages = dto.rocketImages
    )

    private fun mapRocketHeightDtoToEntity(dto: RocketHeightDto) = RocketHeight(
        meters = dto.meters,
        feet = dto.feet
    )

    private fun mapRocketDiameterDtoToEntity(dto: RocketDiameterDto) = RocketDiameter(
        meters = dto.meters,
        feet = dto.feet
    )

    private fun mapRocketMassDtoToEntity(dto: RocketMassDto) = RocketMass(
        kilograms = dto.kilograms,
        pounds = dto.pounds
    )

    private fun mapPayloadWeightListDtoToEntity(list: List<RocketPayloadWeightDto>): List<RocketPayloadWeight> {
        return list.map {
            mapRocketPayloadWeightDtoToEntity(it)
        }
    }

    private fun mapRocketPayloadWeightDtoToEntity(dto: RocketPayloadWeightDto) = RocketPayloadWeight(
        kilograms = dto.kilograms,
        pounds = dto.pounds
    )

    private fun mapRocketFirstStageDtoToEntity(dto: RocketFirstStageDto) = RocketFirstStage(
        engineCount = dto.engineCount,
        fuelAmount = dto.fuelAmount,
        burnTime = dto.burnTime
    )

    private fun mapRocketSecondStageDtoToEntity(dto: RocketSecondStageDto) = RocketSecondStage(
        engineCount = dto.engineCount,
        fuelAmount = dto.fuelAmount,
        burnTime = dto.burnTime
    )
}