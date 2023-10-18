package com.example.feature_clients.mappers

import com.example.core_android.Mapper
import com.example.core_network.api.clients.dtos.ClientDto
import com.example.feature_clients.entities.Client
import com.example.feature_clients.entities.Counter
import javax.inject.Inject

class ClientsMapper @Inject constructor(): Mapper<ClientDto, Client> {
    override fun map(item: ClientDto): Client =
        Client(
            item.name,
            item.constructionId,
            Counter(0, 0, 0)
        )
}