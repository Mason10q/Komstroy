package com.example.feature_auth.mappers

import com.example.core_android.Mapper
import com.example.core_network.api.clients.dtos.ClientDto
import com.example.feature_auth.entities.Client
import javax.inject.Inject

class ClientsMapper @Inject constructor(): Mapper<ClientDto, Client> {
    override fun map(item: ClientDto): Client = Client(
        item.name,
        item.constructionId,
        0, 0, 0
    )
}