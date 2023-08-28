package com.example.komstroy

import com.example.core_android.di.AndroidModule
import com.example.core_android.di.CoreModule
import com.example.feature_clients.ClientsFragment
import com.example.komstroy.photos.ForemenClientsFragment
import com.example.komstroy.photos.PhotosFragment
import com.example.komstroy.houses.HousesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, AndroidModule::class, ViewModelModule::class])
interface MainComponent {

    fun inject(fragment: com.example.feature_clients.ClientsFragment)
    fun inject(fragment: HousesFragment)
    fun inject(fragment: PhotosFragment)
    fun inject(fragment: ForemenClientsFragment)

    @Component.Builder
    interface Builder {
        fun build(): MainComponent

        fun androidModule(module: AndroidModule): Builder
    }

}