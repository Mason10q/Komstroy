package com.example.core_network.api.photos.dtos

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("photo_url")
    val photoUrl: String
)