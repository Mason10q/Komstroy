package com.example.core_network.api.clients.dtos

import com.google.gson.annotations.SerializedName

data class ClientDto(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("construction_id")
    val constructionId: Int = 1
)