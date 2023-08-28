package com.example.core_network.api.clients.dtos

import com.google.gson.annotations.SerializedName

data class ClientCounterDto(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("news_counter")
    val newsCounter: Int = 0,
    @SerializedName("photo_counter")
    val photoCounter: Int = 0,
    @SerializedName("task_counter")
    val taskCounter: Int = 0,
    @SerializedName("construction_id")
    val constructionId: Int = 1
)