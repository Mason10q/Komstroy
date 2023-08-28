package com.example.feature_construction.entities

data class Construction(
    val foreman: Foremen,
    val currentState: String,
    val address: String,
    val startDate: String
)