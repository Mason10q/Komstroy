package com.example.feature_clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core_android.di.AndroidModule
import com.example.core_android.ui.BaseAdapter
import com.example.core_android.ui.BaseListFragment
import com.example.feature_clients.databinding.FragmentClientsBinding
import com.example.feature_clients.databinding.ItemClientBinding

abstract class ClientsFragment :
    BaseListFragment<Client, ItemClientBinding, ClientsAdapter, ClientsViewModel, FragmentClientsBinding>(
        ClientsViewModel::class.java,
        FragmentClientsBinding::inflate,
    ) {

    override val adapter = ClientsAdapter()

    override fun inject() = DaggerMainComponent
        .builder()
        .androidModule(AndroidModule(requireContext()))
        .build()
        .inject(this)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recycler.adapter = adapter


        return super.onCreateView(inflater, container, savedInstanceState)
    }

}


class ClientsAdapter: BaseAdapter<Client, ItemClientBinding>(ItemClientBinding::inflate) {

    override fun bindViews(binding: ItemClientBinding, item: Client, position: Int) {
        with(binding) {
            name.text = item.name
            newsCount.text = item.newsCounter.toString()
            photoCount.text = item.photoCounter.toString()
            taskCount.text = item.taskCounter.toString()
        }
    }

}