package com.example.feature_photos.mappers

import com.example.core_android.Mapper
import com.example.core_android.base_url
import com.example.core_network.api.gallery.dtos.VideoDto
import com.example.feature_photos.entities.Video
import javax.inject.Inject

class VideoMapper @Inject constructor(): Mapper<VideoDto, Video> {
    override fun map(item: VideoDto): Video = Video(
        base_url + item.videoUrl,
        base_url + item.thumbnailUrl,
        item.constructionId,
        item.duration,
        item.uploadDate
    )
}