package com.example.feature_auth.ui

import com.example.core_android.ui.BaseAdapter
import com.example.core_network.api.workers.dtos.WorkerDto
import com.example.feature_auth.databinding.ItemChooseBinding
import com.example.feature_auth.entities.Client
import com.example.feature_auth.entities.Foremen

class ClientsAdapter: BaseAdapter<Client, ItemChooseBinding>(ItemChooseBinding::inflate){
    override fun bindViews(binding: ItemChooseBinding, item: Client, position: Int) {
        binding.name.text = item.name
    }
}

class WorkersAdapter: BaseAdapter<WorkerDto, ItemChooseBinding>(ItemChooseBinding::inflate){
    override fun bindViews(binding: ItemChooseBinding, item: WorkerDto, position: Int) {
        binding.name.text = item.name
    }
}

class ForemensAdapter: BaseAdapter<Foremen, ItemChooseBinding>(ItemChooseBinding::inflate){
    override fun bindViews(binding: ItemChooseBinding, item: Foremen, position: Int) {
        binding.name.text = item.name
    }
}