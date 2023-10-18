package com.example.feature_clients.entities

import com.google.gson.annotations.SerializedName

data class Client(
    val name: String,
    val constructionId: Int,
    val counter: Counter
)