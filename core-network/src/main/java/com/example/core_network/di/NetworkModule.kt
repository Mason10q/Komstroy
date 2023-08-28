package com.example.core_network.di

import com.example.core_network.api.Api
import com.example.core_network.api.AuthApi
import com.example.core_network.api.clients.ClientsApi
import com.example.core_network.api.construction.ConstructionApi
import com.example.core_network.api.foremens.ForemensApi
import com.example.core_network.api.houses.HouseApi
import com.example.core_network.api.workers.WorkersApi
import com.example.core_network.buildApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideGson() = GsonBuilder().setLenient().create()

    @Provides
    fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Singleton
    @Provides
    fun provideApi(client: OkHttpClient, gson: Gson) = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())


    @Singleton
    @Provides
    fun provideClientsApi(builder: Retrofit.Builder) = builder.buildApi<ClientsApi>()


    @Singleton
    @Provides
    fun provideConstructionApi(builder: Retrofit.Builder) = builder.buildApi<ConstructionApi>()


    @Singleton
    @Provides
    fun provideForemensApi(builder: Retrofit.Builder) = builder.buildApi<ForemensApi>()


    @Singleton
    @Provides
    fun provideHousesApi(builder: Retrofit.Builder) = builder.buildApi<HouseApi>()


    @Singleton
    @Provides
    fun provideWorkersApi(builder: Retrofit.Builder) = builder.buildApi<WorkersApi>()


    @Singleton
    @Provides
    fun provideCAuthApi(builder: Retrofit.Builder) = builder.buildApi<AuthApi>()
}