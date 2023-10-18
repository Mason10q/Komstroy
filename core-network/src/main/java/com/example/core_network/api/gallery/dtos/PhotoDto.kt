package com.example.core_network.api.gallery.dtos

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("photo_url")
    val photoUrl: String = "",
    @SerializedName("construction_id")
    val constructionId: Int = 1,
    @SerializedName("upload_date")
    val uploadDate: String = ""
)