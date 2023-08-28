package com.example.feature_clients

import com.example.core_android.Mapper
import com.example.core_network.api.clients.dtos.ClientDto
import javax.inject.Inject

class ClientsMapper @Inject constructor(): Mapper<ClientDto, com.example.feature_clients.Client> {
    override fun map(item: ClientDto): com.example.feature_clients.Client =
        com.example.feature_clients.Client(
            item.name,
            item.constructionId,
            0, 0, 0
        )
}