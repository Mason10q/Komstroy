package com.example.komstroy

import com.example.core_android.di.AndroidModule
import com.example.core_android.di.CoreModule
import com.example.komstroy.houses.HousesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, AndroidModule::class, ViewModelModule::class])
interface MainComponent {

    fun inject(fragment: HousesFragment)
    @Component.Builder
    interface Builder {
        fun build(): MainComponent

        fun androidModule(module: AndroidModule): Builder
    }

}