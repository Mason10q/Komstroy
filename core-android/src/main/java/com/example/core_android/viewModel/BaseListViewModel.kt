package com.example.core_android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class BaseListViewModel<DATA: Any>: BaseViewModel() {

    protected val _data = MutableLiveData<List<DATA>>()
    val data: LiveData<List<DATA>> = _data

}