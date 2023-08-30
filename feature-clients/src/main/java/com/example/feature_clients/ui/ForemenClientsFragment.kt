package com.example.komstroy.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core_navigation.R as navR
import com.example.core_android.constructionIdKey
import com.example.core_android.foremenIdKey
import com.example.feature_clients.entities.Client
import com.example.feature_clients.ui.ClientsFragment

class ForemenClientsFragment : ClientsFragment(){

    override fun onViewClicked(view: View, item: Client) {
        findNavController().navigate(navR.id.photosFragment, bundleOf(constructionIdKey to item.constructionId))
    }

    override fun getData() {
        arguments?.getInt(foremenIdKey)?.let { viewModel.getForemenClients(it) }
    }

}