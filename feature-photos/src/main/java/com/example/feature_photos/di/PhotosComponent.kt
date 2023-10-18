package com.example.feature_photos.di

import com.example.core_android.di.AndroidModule
import com.example.feature_photos.ui.FullScreenFragment
import com.example.feature_photos.ui.GalleryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PhotosModule::class, GalleryModule::class, AndroidModule::class])
interface PhotosComponent {

    fun inject(fragment: GalleryFragment)
    fun inject(fragment: FullScreenFragment)

    @Component.Builder
    interface Builder{
        fun build(): PhotosComponent
        fun androidModule(module: AndroidModule): Builder
    }

}