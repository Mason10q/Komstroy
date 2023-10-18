package com.example.feature_photos.model

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.feature_photos.entities.File
import com.example.core_android.utils.FileUtil
import com.example.core_android.viewModel.BaseViewModel
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
    private val repository: PhotosRepository
) : BaseViewModel() {

    private val _files = MutableLiveData<List<File>>()
    val files: LiveData<List<File>> = _files

    private val _uploaded = MutableLiveData<Boolean>()
    val uploaded: LiveData<Boolean> = _uploaded

    fun uploadFile(context: Context, uri: Uri, constructionId: Int) = composite.add(
        repository.uploadFile(FileUtil.from(context, uri), "image", constructionId)
            .subscribe({
                _uploaded.postValue(it.isSuccessful)
            }, {
                _error.postValue(it.message)
            })
    )

    fun getFiles(constructionId: Int) = composite.add(
        repository.getFiles(constructionId)
            .subscribe({ files ->
                _files.postValue(files)
            }, {
                _error.postValue(it.message)
            })
    )

}