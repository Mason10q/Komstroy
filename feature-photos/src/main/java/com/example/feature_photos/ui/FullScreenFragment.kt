package com.example.feature_photos.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.core_android.constructionIdKey
import com.example.core_android.currentItemKey
import com.example.core_android.di.AndroidModule
import com.example.core_android.viewModel.ViewModelFactory
import com.example.feature_photos.databinding.FragmentFullScreenBinding
import com.example.feature_photos.delegate.file.FullScreenCompositeAdapter
import com.example.feature_photos.di.DaggerPhotosComponent
import com.example.feature_photos.model.PhotosViewModel
import javax.inject.Inject

class FullScreenFragment: Fragment() {

    private val binding by lazy { FragmentFullScreenBinding.inflate(layoutInflater) }

    @Inject lateinit var adapter: FullScreenCompositeAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[PhotosViewModel::class.java]
    }

    private fun inject() =
        DaggerPhotosComponent.builder()
            .androidModule(AndroidModule(requireContext()))
            .build()
            .inject(this)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()
        prepareObservers()
        refresh()

        return binding.root
    }


    private fun prepareObservers() {
        viewModel.error.observe(viewLifecycleOwner) {
            Log.d("taggg", it)
        }

        viewModel.files.observe(viewLifecycleOwner) { files ->
            adapter.setData(files.sortedBy { it.dateTime })

            binding.pager.adapter = adapter
            binding.pager.postDelayed({ binding.pager.currentItem =
                arguments?.getInt(currentItemKey)!!
            }, 100)
        }
    }

    private fun refresh() {
        arguments?.getInt(constructionIdKey)?.let { viewModel.getFiles(it) }
    }

}