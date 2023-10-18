package com.example.feature_construction.di

import androidx.lifecycle.ViewModel
import com.example.core_android.Mapper
import com.example.core_android.di.CoreModule
import com.example.core_android.di.ViewModelKey
import com.example.core_network.api.construction.dtos.ConstructionDto
import com.example.core_network.api.construction.dtos.StateDto
import com.example.core_network.di.NetworkModule
import com.example.feature_construction.model.ConstrViewModel
import com.example.feature_construction.entities.Construction
import com.example.feature_construction.mappers.ConstrMapper
import com.example.feature_construction.mappers.StateMapper
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [NetworkModule::class])
interface ConstrModule {

    @Binds
    fun bindConstructionMapper(mapper: ConstrMapper): Mapper<ConstructionDto, Construction>

    @Binds
    fun bindStateMapper(mapper: StateMapper): Mapper<StateDto, String>

    @Binds
    @IntoMap
    @ViewModelKey(ConstrViewModel::class)
    fun bindConstrViewModel(viewModel: ConstrViewModel): ViewModel

}