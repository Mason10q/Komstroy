package com.example.feature_clients.ui

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core_navigation.R as navR
import com.example.core_android.constructionIdKey
import com.example.core_android.foremenIdKey
import com.example.feature_clients.entities.Client

class ForemenClientsFragment : ClientsFragment(){

    override fun onViewClicked(view: View, item: Client) {
        findNavController().navigate(navR.id.galleryFragment, bundleOf(constructionIdKey to item.constructionId))
    }

    override fun getData() {
        arguments?.getInt(foremenIdKey)?.let { viewModel.getForemenClients(it) }
    }

}