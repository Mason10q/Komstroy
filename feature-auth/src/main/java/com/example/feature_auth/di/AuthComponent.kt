package com.example.feature_auth.di

import com.example.core_android.di.AndroidModule
import com.example.core_android.di.CoreModule
import com.example.feature_auth.ui.ChooseNameFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AuthModule::class, CoreModule::class])
interface AuthComponent {

    fun inject(fragment: ChooseNameFragment)

    @Component.Builder
    interface Builder{
        fun build(): AuthComponent
    }

}