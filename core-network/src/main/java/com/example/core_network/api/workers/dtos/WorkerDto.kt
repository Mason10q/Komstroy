package com.example.core_network.api.workers.dtos

import com.google.gson.annotations.SerializedName

data class WorkerDto(
    @SerializedName("id")
    val id: Int = 1,
    @SerializedName("name")
    val name: String = ""
)