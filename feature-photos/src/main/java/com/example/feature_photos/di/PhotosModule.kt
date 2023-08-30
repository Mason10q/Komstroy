package com.example.feature_photos

import androidx.lifecycle.ViewModel
import com.example.core_android.di.CoreModule
import com.example.core_android.di.ViewModelKey
import com.example.core_network.di.NetworkModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PhotosModule {


    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    fun bindPhotosViewModel(viewModel: PhotosViewModel): ViewModel

}