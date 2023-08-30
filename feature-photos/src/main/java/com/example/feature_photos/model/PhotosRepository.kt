package com.example.feature_photos

import com.example.core_network.api.photos.PhotosApi
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
    private val api: PhotosApi
) {

    fun uploadFile(file: File, type: String, constructionId: Int): Single<Response<ResponseBody>> {
        val requestBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData(type, file.name, requestBody)

        return api.uploadFile(part, constructionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getFiles(constructionId: Int) = api.getPhotos(constructionId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}