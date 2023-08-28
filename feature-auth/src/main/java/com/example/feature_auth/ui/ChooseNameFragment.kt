package com.example.feature_auth.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feature_auth.entities.Roles
import com.example.core_android.constructionIdKey
import com.example.core_android.foremenIdKey
import com.example.core_android.roleKey
import com.example.core_android.viewModel.ViewModelFactory
import com.example.feature_auth.ChooseNameViewModel
import com.example.feature_auth.databinding.FragmentChooseNameBinding
import com.example.feature_auth.di.DaggerAuthComponent
import javax.inject.Inject
import com.example.core_navigation.R as navR

class ChooseNameFragment : Fragment() {

    private fun inject() = DaggerAuthComponent
        .builder()
        .build()
        .inject(this)


    @Inject lateinit var factory: ViewModelFactory
    private val viewModel by lazy { ViewModelProvider(this, factory)[ChooseNameViewModel::class.java] }

    private val binding by lazy { FragmentChooseNameBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun getData(role: Roles) {
        when (role) {
            Roles.CLIENT -> viewModel.getClients()
            Roles.WORKER -> viewModel.getWorkers()
            Roles.FOREMAN -> viewModel.getForemens()
        }
    }

    fun prepareObservers() {

        with(viewModel) {
            clients.observe(viewLifecycleOwner) { clients ->
                val adapter = ClientsAdapter()

                adapter.setOnViewClicked{ _, item ->
                    findNavController().navigate(navR.id.nav_client, bundleOf(constructionIdKey to item.constructionId))
                }

                binding.recycler.adapter = adapter
                adapter.setItems(clients)
            }

            workers.observe(viewLifecycleOwner) { workers ->
                val adapter = WorkersAdapter()

                adapter.setOnViewClicked{ _, _ ->
                    findNavController().navigate(navR.id.nav_worker)
                }

                binding.recycler.adapter = adapter
                adapter.setItems(workers)
            }

            foremens.observe(viewLifecycleOwner) { foremens ->
                val adapter = ForemensAdapter()

                adapter.setOnViewClicked{ _, item ->
                    findNavController().navigate(navR.id.nav_foreman, bundleOf(foremenIdKey to item.id))
                }

                binding.recycler.adapter = adapter
                adapter.setItems(foremens)
            }
        }

    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()
        prepareObservers()
        arguments?.getSerializable(roleKey, Roles::class.java)?.let { getData(it) }

        return binding.root
    }

}