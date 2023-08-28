package com.example.komstroy.mappers

import com.example.core_android.Mapper
import com.example.komstroy.entities.Construction
import com.example.core_network.api.construction.dtos.ConstructionDto
import com.example.komstroy.entities.Foremen
import javax.inject.Inject

class ConstrMapper @Inject constructor():
    Mapper<ConstructionDto, Construction> {

    override fun map(item: ConstructionDto): Construction =
        Construction(
            Foremen(item.foremenId, item.foremenName, item.foremenPhone, item.messengerName, item.foremenTelegramTag),
            item.stateName,
            item.address,
            item.startDate
        )
}