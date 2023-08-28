package com.example.feature_clients.di

import androidx.lifecycle.ViewModel
import com.example.core_android.di.ViewModelKey
import com.example.feature_clients.ClientsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ClientsModule {

    

    @Binds
    @IntoMap
    @ViewModelKey(ClientsViewModel::class)
    fun bindClientsViewModel(viewModel: ClientsViewModel): ViewModel

}