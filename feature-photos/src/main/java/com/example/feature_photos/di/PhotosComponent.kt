package com.example.feature_photos

import com.example.core_android.di.AndroidModule
import dagger.Component
import dagger.Component.Builder
import javax.inject.Singleton

@Singleton
@Component(modules = [PhotosModule::class, AndroidModule::class])
interface PhotosComponent {

    fun inject(fragment: PhotosFragment)

    @Component.Builder
    interface Builder{
        fun build(): PhotosComponent
        fun androidModule(module: AndroidModule): Builder
    }

}