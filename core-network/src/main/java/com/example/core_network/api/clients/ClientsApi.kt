package com.example.core_network.api.clients

import com.example.core_network.api.clients.dtos.ClientCounterDto
import com.example.core_network.api.clients.dtos.ClientDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientsApi {

    @GET("/allClients")
    fun getAllClients(): Single<List<ClientDto>>

    @GET("/houseClients")
    fun getHouseClients(
        @Query("house_id") houseId: Int
    ): Single<List<ClientCounterDto>>

    @GET("/foremenClients")
    fun getForemenClients(
        @Query(value = "foremen_id") foremenId: Int
    ): Single<List<ClientCounterDto>>

}