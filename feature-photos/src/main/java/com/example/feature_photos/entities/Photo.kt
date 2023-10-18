package com.example.feature_photos.entities

data class Photo(
    val photoUrl: String,
    val constructionId: Int,
    val date: String
): File(date){
    fun getId() = photoUrl.hashCode()
}