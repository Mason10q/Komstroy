package com.example.feature_clients.ui

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core_android.constructionIdKey
import com.example.core_android.houseIdKey
import com.example.feature_clients.entities.Client
import com.example.core_navigation.R as navR

class HouseClientsFragment: ClientsFragment() {

    override fun getData() {
        arguments?.let { viewModel.getHouseClients(it.getInt(houseIdKey)) }
    }

    override fun onViewClicked(view: View, item: Client) {
        findNavController().navigate(navR.id.constrFragment2, bundleOf(constructionIdKey to item.constructionId))
    }

}