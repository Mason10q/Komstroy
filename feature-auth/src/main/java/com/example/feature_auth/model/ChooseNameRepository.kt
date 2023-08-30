package com.example.feature_auth

import com.example.core_network.api.AuthApi
import com.example.feature_auth.mappers.ClientsMapper
import com.example.feature_auth.mappers.ForemenMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ChooseNameRepository @Inject constructor(
    private val api: AuthApi,
    private val clientsMapper: ClientsMapper,
    private val foremenMapper: ForemenMapper
) {

    fun getAllClients() = api.getAllClients()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(clientsMapper::map)

    fun getALlWorkers() = api.getAllWorkers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getAllForemens() = api.getAllForemens()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(foremenMapper::map)

}