package com.example.core_network.api.construction.dtos

import com.google.gson.annotations.SerializedName

data class StateDto(
    @SerializedName("state")
    val state: String = ""
)