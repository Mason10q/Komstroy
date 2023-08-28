package com.example.komstroy.mappers

import com.example.core_android.Mapper
import com.example.feature_clients.Client
import com.example.core_network.api.clients.dtos.ClientCounterDto
import javax.inject.Inject

class ClientsCounterMapper @Inject constructor(): Mapper<ClientCounterDto, com.example.feature_clients.Client> {

    override fun map(item: ClientCounterDto): com.example.feature_clients.Client =
        com.example.feature_clients.Client(
            item.name,
            item.constructionId,
            item.newsCounter,
            item.photoCounter,
            item.taskCounter
        )
}