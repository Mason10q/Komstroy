package com.example.core_network.api.gallery.dtos

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id")
    val id: Int = 1,
    @SerializedName("video_url")
    val videoUrl: String = "",
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String = "",
    @SerializedName("construction_id")
    val constructionId: Int = 1,
    @SerializedName("duration")
    val duration: String = "",
    @SerializedName("upload_date")
    val uploadDate: String = ""
)