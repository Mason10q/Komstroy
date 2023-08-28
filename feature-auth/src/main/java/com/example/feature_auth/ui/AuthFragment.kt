package com.example.feature_auth.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.feature_auth.databinding.FragmentAuthBinding
import com.example.feature_auth.entities.Roles
import com.example.core_navigation.R as navR

class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAuthBinding.inflate(inflater, container, false)

        with(binding) {
            workerBtn.setOnClickListener{ navigate(Roles.WORKER) }
            clientBtn.setOnClickListener { navigate(Roles.CLIENT) }
            foremanBtn.setOnClickListener { navigate(Roles.FOREMAN) }
        }

        return binding.root
    }

    private fun navigate(role: Roles){
        findNavController().navigate(navR.id.chooseNameFragment, bundleOf(com.example.core_android.roleKey to role))
    }

}