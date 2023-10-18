package com.example.feature_photos.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core_android.utils.ResultAppNavigator
import com.example.core_android.constructionIdKey
import com.example.core_android.currentItemKey
import com.example.core_android.di.AndroidModule
import com.example.core_android.itemsKey
import com.example.core_android.viewModel.ViewModelFactory
import com.example.feature_photos.databinding.FragmentGalleryBinding
import com.example.feature_photos.di.DaggerPhotosComponent
import com.example.feature_photos.model.PhotosViewModel
import com.example.feature_photos.delegate.gallery.GalleryCompositeAdapter
import javax.inject.Inject
import kotlin.properties.Delegates
import com.example.core_navigation.R as navR


class GalleryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[PhotosViewModel::class.java]
    }

    private val binding by lazy { FragmentGalleryBinding.inflate(layoutInflater) }

    private val camera =
        ResultAppNavigator.Camera(::registerForActivityResult, ::registerForActivityResult)
    private val video =
        ResultAppNavigator.Video(::registerForActivityResult, ::registerForActivityResult)

    @Inject
    lateinit var adapter: GalleryCompositeAdapter

    private val constructionId by lazy { arguments?.getInt(constructionIdKey) }

    private fun inject() =
        DaggerPhotosComponent.builder()
            .androidModule(AndroidModule(requireContext()))
            .build()
            .inject(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()

        camera.createLaunchers(requireContext()) { result ->
            if (result && camera.input != null) {
                if (constructionId != null) {
                    viewModel.uploadFile(requireContext(), camera.input!!, constructionId!!)
                }
            }
        }

        video.createLaunchers(requireContext()) { result ->
            if (result!! && video.input != null) {
                if (constructionId != null) {
                    viewModel.uploadFile(requireContext(), video.input!!, constructionId!!)
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()
        prepareObservers()
        bindView()
        refresh()

        return binding.root
    }

    private fun bindView() {
        binding.photoBtn.setOnClickListener { camera.launch() }
        binding.videoBtn.setOnClickListener { video.launch() }

        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recycler.adapter = this@GalleryFragment.adapter

        adapter.setOnViewClicked { pos ->
            findNavController().navigate(
                navR.id.fullScreenFragment, bundleOf(
                    constructionIdKey to constructionId, currentItemKey to pos
                )
            )
        }
    }


    private fun prepareObservers() {
        viewModel.uploaded.observe(viewLifecycleOwner) { success ->
            if (success) {
                refresh()
            }
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Log.d("taggg", it)
        }

        viewModel.files.observe(viewLifecycleOwner) { files ->
            adapter.setData(files.sortedBy { it.dateTime })
        }
    }

    private fun refresh() {
        constructionId?.let { viewModel.getFiles(it) }
    }

}