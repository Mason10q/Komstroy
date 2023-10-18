package com.example.komstroy.mappers

import com.example.core_android.Mapper
import com.example.feature_clients.entities.Client
import com.example.core_network.api.clients.dtos.ClientCounterDto
import com.example.feature_clients.entities.Counter
import javax.inject.Inject

class ClientsCounterMapper @Inject constructor() : Mapper<ClientCounterDto, Client> {

    override fun map(item: ClientCounterDto): Client =
        Client(
            item.name,
            item.constructionId,
            Counter(
                item.newsCounter,
                item.photoCounter,
                item.taskCounter
            )
        )
}