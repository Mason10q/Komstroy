package com.example.feature_clients.di

import com.example.core_network.di.NetworkModule
import com.example.feature_clients.ui.ClientsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ClientsModule::class])
interface ClientsComponent {

    fun inject(fragment: ClientsFragment)

    @Component.Builder
    interface Builder{
        fun build(): ClientsComponent
    }

}