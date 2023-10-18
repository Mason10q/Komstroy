package com.example.feature_photos.di

import androidx.lifecycle.ViewModel
import com.example.core_android.Mapper
import com.example.core_android.di.ViewModelKey
import com.example.core_android.ui.delegateAdapter.BaseDelegateAdapter
import com.example.core_network.api.gallery.dtos.PhotoDto
import com.example.core_network.api.gallery.dtos.VideoDto
import com.example.feature_photos.databinding.ItemFullPhotoBinding
import com.example.feature_photos.databinding.ItemFullVideoBinding
import com.example.feature_photos.databinding.ItemPhotoSmallBinding
import com.example.feature_photos.databinding.ItemVideoSmallBinding
import com.example.feature_photos.delegate.file.FullPhotoDelegateAdapter
import com.example.feature_photos.delegate.file.FullVideoDelegateAdapter
import com.example.feature_photos.entities.Photo
import com.example.feature_photos.entities.Video
import com.example.feature_photos.mappers.PhotoMapper
import com.example.feature_photos.mappers.VideoMapper
import com.example.feature_photos.model.PhotosViewModel
import com.example.feature_photos.delegate.gallery.PhotoDelegateAdapter
import com.example.feature_photos.delegate.gallery.VideoDelegateAdapter
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PhotosModule {

    @Binds
    fun bindPhotoMapper(mapper: PhotoMapper): Mapper<PhotoDto, Photo>

    @Binds
    fun bindVideoMapper(mapper: VideoMapper): Mapper<VideoDto, Video>

    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    fun bindPhotosViewModel(viewModel: PhotosViewModel): ViewModel

    @Binds
    fun bindPhotoDelegateAdapter(adapter: PhotoDelegateAdapter): BaseDelegateAdapter<Photo, ItemPhotoSmallBinding>

    @Binds
    fun bindVideoDelegateAdapter(adapter: VideoDelegateAdapter): BaseDelegateAdapter<Video, ItemVideoSmallBinding>

    @Binds
    fun bindFullPhotoDelegateAdapter(adapter: FullPhotoDelegateAdapter): BaseDelegateAdapter<Photo, ItemFullPhotoBinding>

    @Binds
    fun bindFullVideoDelegateAdapter(adapter: FullVideoDelegateAdapter): BaseDelegateAdapter<Video, ItemFullVideoBinding>

}