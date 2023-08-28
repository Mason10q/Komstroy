package com.example.core_android.di

import androidx.lifecycle.ViewModelProvider
import com.example.core_android.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface CoreModule {

    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

}