package com.example.feature_photos.mappers

import com.example.core_android.Mapper
import com.example.core_android.base_url
import com.example.core_network.api.gallery.dtos.PhotoDto
import com.example.feature_photos.entities.Photo
import javax.inject.Inject

class PhotoMapper @Inject constructor() : Mapper<PhotoDto, Photo> {
    override fun map(item: PhotoDto): Photo =
        Photo(base_url + item.photoUrl, item.constructionId, item.uploadDate)
}