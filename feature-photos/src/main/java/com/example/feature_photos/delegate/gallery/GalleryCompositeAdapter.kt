package com.example.feature_photos.delegate.gallery

import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.core_android.ui.delegateAdapter.CompositeDelegateAdapter
import com.example.feature_photos.databinding.ItemPhotoSmallBinding
import com.example.feature_photos.databinding.ItemVideoSmallBinding
import com.example.feature_photos.entities.Photo
import com.example.feature_photos.entities.Video
import javax.inject.Inject

class GalleryCompositeAdapter @Inject constructor(
    private val photoDelegateAdapter: BaseDelegateAdapter<Photo, ItemPhotoSmallBinding>,
    private val videoDelegateAdapter: BaseDelegateAdapter<Video, ItemVideoSmallBinding>
): CompositeDelegateAdapter(
    photoDelegateAdapter,
    videoDelegateAdapter
){
    fun setOnViewClicked(listener: (position: Int) -> Unit){
        photoDelegateAdapter.setOnViewClicked(listener)
    }
}