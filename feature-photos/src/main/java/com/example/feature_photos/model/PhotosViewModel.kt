package com.example.feature_photos

import android.content.Context
import android.net.Uri
import com.example.core_android.utils.FileUtil
import com.example.core_android.viewModel.BaseListViewModel
import com.example.core_android.viewModel.BaseViewModel
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
    private val repository: PhotosRepository
) : BaseViewModel() {

    fun uploadFile(context: Context, uri: Uri, constructionId: Int) = composite.add(
        repository.uploadFile(FileUtil.from(context, uri), "image", constructionId)
            .subscribe({}, {
                _error.postValue(it.message)
            })
    )


}