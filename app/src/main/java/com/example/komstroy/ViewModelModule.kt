package com.example.komstroy

import androidx.lifecycle.ViewModel
import com.example.core_android.di.ViewModelKey
import com.example.core_network.di.NetworkModule
import com.example.komstroy.houses.HousesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HousesViewModel::class)
    fun bindHousesViewModel(viewModel: HousesViewModel): ViewModel


}