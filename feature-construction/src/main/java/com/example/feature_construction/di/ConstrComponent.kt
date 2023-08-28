package com.example.feature_construction.di

import com.example.feature_construction.ui.ConstrFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ConstrModule::class])
interface ConstrComponent {

    fun inject(fragment: ConstrFragment)

    @Component.Builder
    interface Builder{
        fun build(): ConstrComponent
    }
}