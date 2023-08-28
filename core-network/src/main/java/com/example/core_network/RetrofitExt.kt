package com.example.core_network

import retrofit2.Retrofit


inline fun <reified T : Any> Retrofit.Builder.buildApi(): T =
    baseUrl("http://192.168.1.69:3000")
        .build()
        .create(T::class.java)

