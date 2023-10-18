package com.example.core_network.api.foremens

import com.example.core_network.api.foremens.dtos.ForemenDto
import com.example.core_network.api.gallery.GalleryApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ForemensApi: GalleryApi {

    @GET("/allForemens")
    fun getAllForemens(): Single<List<ForemenDto>>

}