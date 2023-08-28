package com.example.komstroy.photos

import com.example.komstroy.mappers.ClientsCounterMapper
import com.example.core_network.api.Api
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
    private val api: Api,
    private val clientsCounterMapper: ClientsCounterMapper
) {

    fun getClients(foremenName: String) =
        api.getForemenClients(foremenName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map(clientsCounterMapper::map)

    fun uploadFile(file: File, type: String, constructionId: Int): Single<Response<ResponseBody>> {
        val requestBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData(type, file.name, requestBody)

        return api.uploadFile(part, constructionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}