package com.example.komstroy.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.komstroy.DaggerMainComponent
import com.example.komstroy.R
import com.example.core_navigation.R as navR
import com.example.core_android.di.AndroidModule
import com.example.core_android.houseIdKey
import com.example.komstroy.databinding.FragmentHousesBinding
import com.example.komstroy.databinding.ItemHouseBinding
import com.example.komstroy.entities.House
import javax.inject.Inject

class HousesFragment :
    com.example.core_android.ui.BaseListFragment<House, ItemHouseBinding, HousesAdapter, HousesViewModel, FragmentHousesBinding>(
        HousesViewModel::class.java,
        FragmentHousesBinding::inflate
    ) {

    @Inject override lateinit var adapter: HousesAdapter

    override fun getData() {
        viewModel.getHouses()
    }

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

        adapter.setOnViewClicked{ _, item ->
            findNavController().navigate(navR.id.clientsFragment, bundleOf(houseIdKey to item.id))
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

}