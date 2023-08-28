package com.example.feature_auth.mappers

import com.example.core_android.Mapper
import com.example.core_network.api.foremens.dtos.ForemenDto
import com.example.feature_auth.entities.Foremen
import javax.inject.Inject

class ForemenMapper @Inject constructor(): Mapper<ForemenDto, Foremen> {
    override fun map(item: ForemenDto): Foremen = Foremen(
        item.id,
        item.name,
        item.phoneNumber,
        item.telegramTag,
        item.messenger
    )
}