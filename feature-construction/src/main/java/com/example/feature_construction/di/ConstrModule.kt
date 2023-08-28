package com.example.feature_construction.di

import androidx.lifecycle.ViewModel
import com.example.core_android.di.CoreModule
import com.example.core_android.di.ViewModelKey
import com.example.core_network.di.NetworkModule
import com.example.feature_construction.ConstrViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [CoreModule::class, NetworkModule::class])
interface ConstrModule {

    @Binds
    @IntoMap
    @ViewModelKey(ConstrViewModel::class)
    fun bindConstrViewModel(viewModel: ConstrViewModel): ViewModel

}