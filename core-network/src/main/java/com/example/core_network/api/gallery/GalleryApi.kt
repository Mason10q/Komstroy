package com.example.core_network.api.gallery

import com.example.core_network.api.gallery.dtos.PhotoDto
import com.example.core_network.api.gallery.dtos.VideoDto
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface GalleryApi {

    @Multipart
    @POST("/uploadFile")
    fun uploadFile(
        @Part file: MultipartBody.Part,
        @Query("construction_id") constructionId: Int
    ): Single<Response<ResponseBody>>

    @Multipart
    @POST("/uploadFile")
    fun uploadFiles(
        @Part files: List<MultipartBody.Part>,
        @Query("construction_id") constructionId: Int
    ): Single<Response<ResponseBody>>


    @GET("/constructionPhotos")
    fun getPhotos(
        @Query("construction_id") constructionId: Int
    ): Single<List<PhotoDto>>

    @GET("/constructionVideos")
    fun getVideos(
        @Query("construction_id") constructionId: Int
    ): Single<List<VideoDto>>

}