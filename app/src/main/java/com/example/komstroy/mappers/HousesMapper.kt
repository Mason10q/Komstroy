package com.example.komstroy.mappers

import com.example.core_android.Mapper
import com.example.komstroy.entities.House
import com.example.core_network.api.houses.dtos.HouseDto
import javax.inject.Inject

class HousesMapper @Inject constructor(): Mapper<HouseDto, House> {
    override fun map(item: HouseDto): House = House(
        item.id,
        item.name ?: "",
        item.description ?: "",
        item.photoUrl ?: ""
    )
}