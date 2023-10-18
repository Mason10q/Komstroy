package com.example.feature_photos.entities

data class Video(
    val videoUrl: String,
    val thumbnailUrl: String,
    val constructionId: Int,
    val duration: String,
    val date: String
): File(date){
    fun getId() = thumbnailUrl.hashCode()
}