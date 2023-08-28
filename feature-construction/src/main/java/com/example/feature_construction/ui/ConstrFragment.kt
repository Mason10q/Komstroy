package com.example.feature_construction.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.core_android.utils.AppNavigator
import com.example.core_android.viewModel.ViewModelFactory
import com.example.feature_construction.ConstrViewModel
import com.example.feature_construction.entities.Construction
import com.example.feature_construction.entities.Foremen
import com.example.feature_construction.databinding.FragmentConstructionBinding
import com.example.feature_construction.di.DaggerConstrComponent
import javax.inject.Inject


class ConstrFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[ConstrViewModel::class.java] }

    private val binding by lazy { FragmentConstructionBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()

        viewModel.construction.observe(viewLifecycleOwner){ construction ->
            bindViews(construction)
        }

        arguments?.getInt(com.example.core_android.constructionIdKey)?.let { id ->
            viewModel.getConstruction(id)
            registerForActivityResult(ActivityResultContracts.RequestPermission()){
            }
        }

        viewModel.getConstrStates()

        return binding.root
    }

    private fun inject() = DaggerConstrComponent
        .builder()
        .build()


    private fun bindViews(construction: Construction) {
        with(binding) {
            address.text = construction.address
            startDate.text = construction.startDate
            foremanName.text = construction.foreman.name
            roadmapContainer.addView(viewModel.roadMap.createRecycler(requireContext(), construction.currentState))
            callForemen.setOnClickListener{ AppNavigator.Phone(construction.foreman.phoneNumber).connect(requireContext()::startActivity) }
            chatForemen.setOnClickListener{ chatWithForemen(construction.foreman) }
        }
    }

    private fun chatWithForemen(foremen: Foremen) = when(foremen.messenger){
        "WhatsApp" -> AppNavigator.WhatsApp(foremen.phoneNumber).connect(requireContext()::startActivity)
        "Telegram" -> AppNavigator.Telegram(foremen.telegramTag).connect(requireContext()::startActivity)
        else -> {}
    }

}