package com.example.core_network.api.houses.dtos

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class HouseDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("characteristics")
    val description: String? = "",
    @SerializedName("photo_url")
    val photoUrl: String? = ""
)