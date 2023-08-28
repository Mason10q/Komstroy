package com.example.komstroy

import androidx.lifecycle.ViewModel
import com.example.core_android.di.CoreModule
import com.example.core_android.di.ViewModelKey
import com.example.core_network.di.NetworkModule
import com.example.komstroy.clients.ClientsViewModel
import com.example.komstroy.photos.PhotosViewModel
import com.example.komstroy.houses.HousesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [NetworkModule::class])
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HousesViewModel::class)
    fun bindHousesViewModel(viewModel: HousesViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    fun bindForemenViewModel(viewModel: PhotosViewModel): ViewModel

}