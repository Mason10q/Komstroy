package com.example.core_network.api.construction

import com.example.core_network.api.construction.dtos.ConstructionDto
import com.example.core_network.api.construction.dtos.StateDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ConstructionApi {

    @GET("/construction")
    fun getConstruction(
        @Query("construction_id") counstructionId: Int
    ): Single<ConstructionDto>

    @GET("/states")
    fun getStates(): Single<List<StateDto>>

}