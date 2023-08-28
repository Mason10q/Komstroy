package com.example.komstroy.mappers

import com.example.core_android.Mapper
import com.example.core_network.api.construction.dtos.StateDto
import javax.inject.Inject

class StateMapper @Inject constructor(): Mapper<StateDto, String> {
    override fun map(item: StateDto): String = item.state
}