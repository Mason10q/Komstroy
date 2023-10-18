package com.example.feature_auth.di

import androidx.lifecycle.ViewModel
import com.example.core_android.Mapper
import com.example.core_android.di.ViewModelKey
import com.example.core_network.api.clients.dtos.ClientDto
import com.example.core_network.api.foremens.dtos.ForemenDto
import com.example.core_network.di.NetworkModule
import com.example.feature_auth.model.ChooseNameViewModel
import com.example.feature_auth.entities.Client
import com.example.feature_auth.entities.Foremen
import com.example.feature_auth.mappers.ClientsMapper
import com.example.feature_auth.mappers.ForemenMapper
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [NetworkModule::class])
interface AuthModule {


    @Binds
    fun bindClientsMapper(mapper: ClientsMapper): Mapper<ClientDto, Client>

    @Binds
    fun bindForemenMapper(mapper: ForemenMapper): Mapper<ForemenDto, Foremen>

    @Binds
    @IntoMap
    @ViewModelKey(ChooseNameViewModel::class)
    fun bindChooseNameViewModel(viewModel: ChooseNameViewModel): ViewModel
}