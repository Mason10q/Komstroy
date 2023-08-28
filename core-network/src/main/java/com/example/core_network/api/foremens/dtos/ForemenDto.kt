package com.example.core_network.api.foremens.dtos

import com.google.gson.annotations.SerializedName

data class ForemenDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("foremen_phone")
    val phoneNumber: String,
    @SerializedName("telegram_tag")
    val telegramTag: String,
    @SerializedName("messenger")
    val messenger: String
)