package com.example.komstroy.photos

import android.content.Context
import android.net.Uri
import com.example.core_android.utils.FileUtil
import com.example.core_android.viewModel.BaseListViewModel
import com.example.feature_clients.Client
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
    private val repository: PhotosRepository
) : BaseListViewModel<com.example.feature_clients.Client>() {

    fun getClients(foremenName: String) = composite.add(
        repository.getClients(foremenName)
            .subscribe({ clients ->
                _data.postValue(clients)
            }, {
                _error.postValue(it.message)
            })
    )

    fun uploadFile(context: Context, uri: Uri, constructionId: Int) = composite.add(
        repository.uploadFile(FileUtil.from(context, uri), "image", constructionId)
            .subscribe({}, {
                _error.postValue(it.message)
            })
    )


}