package com.example.core_network.api.foremens

import com.example.core_network.api.foremens.dtos.ForemenDto
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ForemensApi {

    @GET("/allForemens")
    fun getAllForemens(): Single<List<ForemenDto>>


    @Multipart
    @POST("/uploadFile")
    fun uploadFile(
        @Part file: MultipartBody.Part,
        @Query("construction_id") constructionId: Int
    ): Single<retrofit2.Response<ResponseBody>>

}