package com.example.feature_clients.di

import com.example.core_network.di.NetworkModule
import com.example.feature_clients.ClientsFragment
import dagger.Component

@Component(modules = [NetworkModule::class, ClientsModule::class])
interface ClientsComponent {

    fun inject(fragment: ClientsFragment)

    @Component.Builder
    interface Builder{
        fun build()
    }

}