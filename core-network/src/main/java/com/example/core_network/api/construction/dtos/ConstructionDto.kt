package com.example.core_network.api.construction.dtos

import com.google.gson.annotations.SerializedName

data class ConstructionDto(
    @SerializedName("start_date")
    val startDate: String = "",
    @SerializedName("address")
    val address: String = "",
    @SerializedName("foremen_id")
    val foremenId: Int = 1,
    @SerializedName("name")
    val foremenName: String = "",
    @SerializedName("foremen_phone")
    val foremenPhone: String = "",
    @SerializedName("telegram_tag")
    val foremenTelegramTag: String = "",
    @SerializedName("messenger")
    val messengerName: String = "",
    @SerializedName("state")
    val stateName: String = ""
)