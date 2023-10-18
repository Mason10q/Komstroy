package com.example.feature_photos.delegate.gallery

import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.feature_photos.databinding.ItemVideoSmallBinding
import com.example.feature_photos.entities.Video
import com.squareup.picasso.Picasso
import javax.inject.Inject

class VideoDelegateAdapter @Inject constructor(
    private val picasso: Picasso
): BaseDelegateAdapter<Video, ItemVideoSmallBinding>(
    ItemVideoSmallBinding::inflate
) {
    override fun ItemVideoSmallBinding.onBind(item: Video, position: Int) {
        picasso.load(item.thumbnailUrl).into(image)
        duration.text = item.duration
        root.setOnClickListener{ onViewClicked(position) }
    }

    override fun Video.getItemId(): Any = getId()

    override fun isForViewType(item: Any): Boolean = item is Video
}