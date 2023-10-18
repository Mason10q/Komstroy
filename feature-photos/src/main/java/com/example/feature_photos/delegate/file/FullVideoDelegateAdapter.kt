package com.example.feature_photos.delegate.file

import android.media.MediaController2
import android.media.session.MediaController
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.feature_photos.databinding.ItemFullVideoBinding
import com.example.feature_photos.entities.Video
import javax.inject.Inject

class FullVideoDelegateAdapter @Inject constructor(): BaseDelegateAdapter<Video, ItemFullVideoBinding>(
    ItemFullVideoBinding::inflate
) {
    override fun ItemFullVideoBinding.onBind(item: Video, position: Int) {
        video.setVideoURI(Uri.parse(item.videoUrl))
        video.start()
    }

    override fun Video.getItemId(): Any = getId()

    override fun isForViewType(item: Any): Boolean = item is Video
}