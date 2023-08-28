package com.example.komstroy.entities

import retrofit2.http.Url

data class House(
    val id: Int,
    val name: String,
    val description: String,
    val photoUrl: String
)