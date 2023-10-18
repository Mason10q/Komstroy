package com.example.feature_construction.mappers

import com.example.core_android.Mapper
import com.example.core_network.api.construction.dtos.ConstructionDto
import com.example.feature_construction.entities.Construction
import com.example.feature_construction.entities.Foremen
import javax.inject.Inject

class ConstrMapper @Inject constructor():
    Mapper<ConstructionDto, Construction> {

    override fun map(item: ConstructionDto): Construction =
        Construction(
            Foremen(item.foremenId, item.foremenName, item.foremenPhone, item.foremenTelegramTag, item.messengerName),
            item.stateName,
            item.address,
            item.startDate
        )
}