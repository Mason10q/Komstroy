package com.example.feature_clients.model

import com.example.core_android.Mapper
import com.example.core_network.api.clients.ClientsApi
import com.example.core_network.api.clients.dtos.ClientCounterDto
import com.example.core_network.api.clients.dtos.ClientDto
import com.example.feature_clients.entities.Client
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ClientsRepository @Inject constructor(
    private val api: ClientsApi,
    private val clientsMapper: Mapper<ClientDto, Client>,
    private val clientCounterMapper: Mapper<ClientCounterDto, Client>
) {

    fun getHouseClients(houseId: Int) = api.getHouseClients(houseId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(clientCounterMapper::map)


    fun getForemenClients(foremenId: Int) = api.getForemenClients(foremenId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(clientCounterMapper::map)

    fun getAllClients() = api.getAllClients()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(clientsMapper::map)
}