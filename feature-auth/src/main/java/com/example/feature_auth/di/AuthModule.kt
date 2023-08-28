package com.example.feature_auth.di

import androidx.lifecycle.ViewModel
import com.example.core_android.di.CoreModule
import com.example.core_android.di.ViewModelKey
import com.example.core_network.di.NetworkModule
import com.example.feature_auth.ChooseNameViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [NetworkModule::class])
interface AuthModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChooseNameViewModel::class)
    fun bindChooseNameViewModel(viewModel: ChooseNameViewModel): ViewModel
}