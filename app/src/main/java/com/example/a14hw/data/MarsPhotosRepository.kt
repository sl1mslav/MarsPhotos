package com.example.a14hw.data

import com.example.a14hw.entity.MarsPhotos
import javax.inject.Inject

class MarsPhotosRepository @Inject constructor(
    private val marsPhotosDataSource: MarsPhotosDataSource
) {
    suspend fun getMarsPhotosFromDataSource(page: Int): MarsPhotos {
        return marsPhotosDataSource.loadMarsPhotos(page = page)
    }
}