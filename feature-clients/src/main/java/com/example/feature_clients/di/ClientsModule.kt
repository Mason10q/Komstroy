package com.example.feature_clients.di

import androidx.lifecycle.ViewModel
import com.example.core_android.Mapper
import com.example.core_android.di.ViewModelKey
import com.example.core_network.api.clients.dtos.ClientCounterDto
import com.example.core_network.api.clients.dtos.ClientDto
import com.example.feature_clients.entities.Client
import com.example.feature_clients.mappers.ClientsMapper
import com.example.feature_clients.model.ClientsViewModel
import com.example.feature_clients.mappers.ClientCounterMapper
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ClientsModule {

    @Binds
    fun bindClientsMapper(mapper: ClientsMapper): Mapper<ClientDto, Client>

    @Binds
    fun bindClientCounterMapper(mapper: ClientCounterMapper): Mapper<ClientCounterDto, Client>

    @Binds
    @IntoMap
    @ViewModelKey(ClientsViewModel::class)
    fun bindClientsViewModel(viewModel: ClientsViewModel): ViewModel

}