package com.example.feature_photos.delegate.gallery

import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.feature_photos.databinding.ItemPhotoSmallBinding
import com.example.feature_photos.entities.Photo
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PhotoDelegateAdapter @Inject constructor(
    private val picasso: Picasso
): BaseDelegateAdapter<Photo, ItemPhotoSmallBinding>(
    ItemPhotoSmallBinding::inflate
) {


    override fun ItemPhotoSmallBinding.onBind(item: Photo, position: Int) {
        picasso.load(item.photoUrl).into(image)
        root.setOnClickListener{ onViewClicked(position) }
    }

    override fun Photo.getItemId(): Any = getId()

    override fun isForViewType(item: Any): Boolean = item is Photo

}