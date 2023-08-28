package com.example.core_network.api.houses

import com.example.core_network.api.houses.dtos.HouseDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface HouseApi {

    @GET("/houses")
    fun getHouses(): Single<List<HouseDto>>

}