package com.example.feature_photos.model

import com.example.core_android.Mapper
import com.example.core_network.api.gallery.GalleryApi
import com.example.core_network.api.gallery.dtos.PhotoDto
import com.example.core_network.api.gallery.dtos.VideoDto
import com.example.feature_photos.entities.Photo
import com.example.feature_photos.entities.Video
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val api: GalleryApi,
    private val photoMapper: Mapper<PhotoDto, Photo>,
    private val videoMapper: Mapper<VideoDto, Video>
) {

    fun uploadFile(file: File, type: String, constructionId: Int): Single<Response<ResponseBody>> {
        val requestBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData(type, file.name, requestBody)

        return api.uploadFile(part, constructionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getPhotos(constructionId: Int) = api.getPhotos(constructionId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(photoMapper::map)

    private fun getVideos(constructionId: Int) = api.getVideos(constructionId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(videoMapper::map)


    fun getFiles(constructionId: Int) = Single.zip(
        getVideos(constructionId),
        getPhotos(constructionId)
    ){ p, v -> p + v }
}