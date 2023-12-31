package com.example.core_android.ui

import android.view.View
import androidx.viewbinding.ViewBinding

interface AdapterCallback<DATA: Any, B: ViewBinding> {

    fun bindViews(binding: B, item: DATA, position: Int)

    fun onViewClicked(view: View, item: DATA)
}