package com.example.feature_clients

import com.google.gson.annotations.SerializedName

data class Client(
    val name: String,
    val constructionId: Int,
    val newsCounter: Int,
    val photoCounter: Int,
    val taskCounter: Int,
)