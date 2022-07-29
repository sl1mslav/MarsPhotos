package com.example.a14hw.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.a14hw.data.MarsPhotoPagingSource
import com.example.a14hw.data.MarsPhotosRepository
import com.example.a14hw.entity.MarsPhoto
import com.example.a14hw.entity.MarsPhotos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMarsPhotosUseCase @Inject constructor(
    private val repository: MarsPhotosRepository
) {

    fun execute(): Flow<PagingData<MarsPhoto>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = { MarsPhotoPagingSource(repository) }
        ).flow
    }
}