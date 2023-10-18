package com.example.feature_photos.delegate.file

import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.core_android.ui.delegateAdapter.CompositeDelegateAdapter
import com.example.feature_photos.databinding.ItemFullPhotoBinding
import com.example.feature_photos.databinding.ItemFullVideoBinding
import com.example.feature_photos.entities.Photo
import com.example.feature_photos.entities.Video
import javax.inject.Inject

class FullScreenCompositeAdapter @Inject constructor(
    fullPhotoDelegateAdapter: BaseDelegateAdapter<Photo, ItemFullPhotoBinding>,
    fullVideoDelegateAdapter: BaseDelegateAdapter<Video, ItemFullVideoBinding>
) : CompositeDelegateAdapter(
    fullPhotoDelegateAdapter,
    fullVideoDelegateAdapter)