package com.example.komstroy.photos

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.komstroy.DaggerMainComponent
import com.example.core_android.utils.ResultAppNavigator
import com.example.core_android.constructionIdKey
import com.example.core_android.di.AndroidModule
import com.example.core_android.viewModel.ViewModelFactory
import com.example.komstroy.databinding.FragmentPhotosBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject


class PhotosFragment : Fragment() {

    @Inject lateinit var picasso: Picasso
    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[PhotosViewModel::class.java] }

    val binding by lazy { FragmentPhotosBinding.inflate(layoutInflater) }

    private val camera =
        ResultAppNavigator.Camera(::registerForActivityResult, ::registerForActivityResult)
    private val video =
        ResultAppNavigator.Video(::registerForActivityResult, ::registerForActivityResult)


    private fun inject() = DaggerMainComponent
        .builder()
        .androidModule(AndroidModule(requireContext()))
        .build()
        .inject(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()

        val constructionId = arguments?.getInt(constructionIdKey)

        camera.createLaunchers(requireContext()) { result ->
            if (result && camera.input != null){
                if (constructionId != null) {
                    viewModel.uploadFile(requireContext(), camera.input!!, constructionId)
                }
            }
        }

        video.createLaunchers(requireContext()) { result ->
            if (result!! && camera.input != null){
                if (constructionId != null) {
                    viewModel.uploadFile(requireContext(), video.input!!, constructionId)
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.photoBtn.setOnClickListener { camera.launch() }
        binding.videoBtn.setOnClickListener { video.launch() }

        viewModel.error.observe(viewLifecycleOwner){
            Log.d("taggg", it)
        }

        return binding.root
    }

}