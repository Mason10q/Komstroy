package com.example.feature_construction.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.core_android.constructionIdKey
import com.example.core_android.utils.AppNavigator
import com.example.core_android.viewModel.ViewModelFactory
import com.example.feature_construction.model.ConstrViewModel
import com.example.feature_construction.entities.Construction
import com.example.feature_construction.entities.Foremen
import com.example.feature_construction.databinding.FragmentConstructionBinding
import com.example.feature_construction.di.DaggerConstrComponent
import javax.inject.Inject
import com.example.core_navigation.R as navR


class ConstrFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[ConstrViewModel::class.java] }

    private val binding by lazy { FragmentConstructionBinding.inflate(layoutInflater) }

    private val constructionId by lazy { arguments?.getInt(constructionIdKey) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()

        viewModel.construction.observe(viewLifecycleOwner){ construction ->
            bindViews(construction)
        }

        constructionId?.let { viewModel.getConstruction(it) }
        viewModel.getConstrStates()

        return binding.root
    }

    private fun inject() = DaggerConstrComponent
        .builder()
        .build()
        .inject(this)


    private fun bindViews(construction: Construction) {
        with(binding) {
            address.text = construction.address
            startDate.text = construction.startDate
            foremanName.text = construction.foreman.name
            roadmapContainer.addView(viewModel.roadMap.createRecycler(requireContext(), construction.currentState))
            callForemen.setOnClickListener{ AppNavigator.Phone(construction.foreman.phoneNumber).connect(requireContext()::startActivity) }
            chatForemen.setOnClickListener{ chatWithForemen(construction.foreman) }
            photoBtn.setOnClickListener {
                findNavController().navigate(navR.id.galleryFragment, bundleOf(constructionIdKey to constructionId))
            }
        }
    }

    private fun chatWithForemen(foremen: Foremen) = when(foremen.messenger){
        "WhatsApp" -> AppNavigator.WhatsApp(foremen.phoneNumber).connect(requireContext()::startActivity)
        "Telegram" -> AppNavigator.Telegram(foremen.telegramTag).connect(requireContext()::startActivity)
        else -> { }
    }

}