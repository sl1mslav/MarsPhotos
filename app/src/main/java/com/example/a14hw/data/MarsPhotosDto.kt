package com.example.a14hw.data

import com.example.a14hw.entity.MarsPhoto
import com.example.a14hw.entity.MarsPhotos
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarsPhotosDto(
    @Json(name = "photos") override val photos: List<MarsPhotoDto>
) : MarsPhotos

@JsonClass(generateAdapter = true)
data class MarsPhotoDto(
    @Json (name = "id") override val id: Int,
    @Json(name = "sol") override val sol: Int,
    @Json(name = "img_src") override val imgSrc: String,
    @Json(name = "earth_date") override val earthDate: String,
    @Json(name = "camera") override val camera: CameraInfoItemDto,
    @Json(name = "rover") override val rover: RoverInfoItemDto
) : MarsPhoto

@JsonClass(generateAdapter = true)
data class CameraInfoItemDto(
    @Json(name = "name") override val name: String
) : MarsPhoto.CameraInfoItem

@JsonClass(generateAdapter = true)
data class RoverInfoItemDto(
    @Json(name = "name") override val name: String
) : MarsPhoto.RoverInfoItem