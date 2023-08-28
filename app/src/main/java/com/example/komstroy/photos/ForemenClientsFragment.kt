package com.example.komstroy.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.komstroy.DaggerMainComponent
import com.example.core_navigation.R as navR
import com.example.feature_clients.ClientsAdapter
import com.example.core_android.constructionIdKey
import com.example.core_android.di.AndroidModule
import com.example.core_android.ui.BaseListFragment
import com.example.komstroy.databinding.FragmentClientsBinding
import com.example.komstroy.databinding.ItemClientBinding
import com.example.feature_clients.Client

abstract class ForemenClientsFragment :
    BaseListFragment<com.example.feature_clients.Client, ItemClientBinding, com.example.feature_clients.ClientsAdapter, PhotosViewModel, FragmentClientsBinding>(
        PhotosViewModel::class.java,
        FragmentClientsBinding::inflate,
    ) {

    override fun inject() = DaggerMainComponent
        .builder()
        .androidModule(AndroidModule(requireContext()))
        .build()
        .inject(this)

    override val adapter = com.example.feature_clients.ClientsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.recycler.adapter = adapter

        adapter.setOnViewClicked{ _, item ->
            findNavController().navigate(navR.id.photosFragment, bundleOf(constructionIdKey to item.constructionId))
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

}