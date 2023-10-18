package com.example.feature_photos.di

import com.example.core_android.ui.delegateAdapter.CompositeDelegateAdapter
import com.example.feature_photos.delegate.file.FullPhotoDelegateAdapter
import com.example.feature_photos.delegate.file.FullScreenCompositeAdapter
import com.example.feature_photos.delegate.file.FullVideoDelegateAdapter
import com.example.feature_photos.delegate.gallery.GalleryCompositeAdapter
import com.example.feature_photos.delegate.gallery.PhotoDelegateAdapter
import com.example.feature_photos.delegate.gallery.VideoDelegateAdapter
import dagger.Module
import dagger.Provides

@Module
class GalleryModule {

    @Provides
    fun provideGalleryCompositeAdapter(
        photoAdapter: PhotoDelegateAdapter,
        videoAdapter: VideoDelegateAdapter
    ): CompositeDelegateAdapter = GalleryCompositeAdapter(photoAdapter, videoAdapter)


    @Provides
    fun provideFullScreenCompositeAdapter(
        fullPhotoAdapter: FullPhotoDelegateAdapter,
        fullVideoAdapter: FullVideoDelegateAdapter
    ): CompositeDelegateAdapter = FullScreenCompositeAdapter(fullPhotoAdapter, fullVideoAdapter)

}