package com.example.feature_photos.delegate.file

import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.feature_photos.databinding.ItemFullPhotoBinding
import com.example.feature_photos.entities.Photo
import com.squareup.picasso.Picasso
import javax.inject.Inject

class FullPhotoDelegateAdapter @Inject constructor(
    private val picasso: Picasso
): BaseDelegateAdapter<Photo, ItemFullPhotoBinding>(
    ItemFullPhotoBinding::inflate
) {
    override fun ItemFullPhotoBinding.onBind(item: Photo, position: Int) {
        picasso.load(item.photoUrl).into(photo)
    }

    override fun Photo.getItemId(): Any = getId()

    override fun isForViewType(item: Any): Boolean = item is Photo
}