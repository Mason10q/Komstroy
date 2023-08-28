package com.example.feature_clients

import com.example.core_android.Mapper
import com.example.core_network.api.Api
import com.example.core_network.api.clients.ClientsApi
import com.example.core_network.api.clients.dtos.ClientDto
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ClientsRepository @Inject constructor(
    private val api: ClientsApi,
    private val clientsMapper: Mapper<ClientDto, Client>
) {

    private fun getHouseClients(houseId: Int) = api.getHouseClients(houseId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}