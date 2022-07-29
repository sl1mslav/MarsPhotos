package com.example.a14hw.data

import javax.inject.Inject

class MarsPhotosDataSource @Inject constructor() {
    suspend fun loadMarsPhotos(page: Int): MarsPhotosDto {
        return RetrofitInstance.searchAPI.getMarsPhotosFromAPI(page = page)
    }
}