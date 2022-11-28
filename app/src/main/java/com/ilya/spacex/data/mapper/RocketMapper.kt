package com.ilya.spacex.data.mapper

import com.ilya.spacex.data.network.model.rocket.*
import com.ilya.spacex.domain.model.*

class RocketMapper {

    fun mapRocketResponseDtoToEntity(dto: RocketResponseDto) = RocketResponse(
        mapRocketResponseDtoListToEntity(dto.rocketList)
    )

    private fun mapRocketResponseDtoListToEntity(list: List<RocketDto>): List<Rocket> {
        return list.map {
            mapRocketDtoToEntity(it)
        }
    }

    private fun mapRocketDtoToEntity(dto: RocketDto) = Rocket(
        name = dto.name,
        height = mapRocketHeightDtoToEntity(dto.height),
        diameter = mapRocketDiameterDtoToEntity(dto.diameter),
        mass = mapRocketMassDtoToEntity(dto.mass),
        payloadWeight = mapRocketPayloadWeightDtoToEntity(dto.payloadWeight),
        firstFlight = dto.firstFlight,
        country = dto.country,
        costLaunch = dto.costLaunch,
        firstStage = mapRocketFirstStageDtoToEntity(dto.firstStage),
        secondStage = mapRocketSecondStageDtoToEntity(dto.secondStage)
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

    private fun mapRocketPayloadWeightDtoToEntity(dto: RocketPayloadWeightDto) = RocketPayloadWeight(
        kilograms = dto.kilograms,
        pounds = dto.pounds
    )

    private fun mapRocketFirstStageDtoToEntity(dto: RocketFirstStageDto) = RocketFirstStage(
        engines = dto.engines,
        fuel_amount_tons = dto.fuel_amount_tons,
        burn_time_sec = dto.burn_time_sec
    )

    private fun mapRocketSecondStageDtoToEntity(dto: RocketSecondStageDto) = RocketSecondStage(
        engines = dto.engines,
        fuel_amount_tons = dto.fuel_amount_tons,
        burn_time_sec = dto.burn_time_sec
    )

}