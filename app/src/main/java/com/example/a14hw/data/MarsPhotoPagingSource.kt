package com.example.a14hw.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.a14hw.entity.MarsPhoto
import javax.inject.Inject

class MarsPhotoPagingSource @Inject constructor(
    private val repository: MarsPhotosRepository
): PagingSource<Int, MarsPhoto>() {

    override fun getRefreshKey(state: PagingState<Int, MarsPhoto>): Int? = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarsPhoto> {

        val page = params.key ?: FIRST_PAGE

        return kotlin.runCatching {
            repository.getMarsPhotosFromDataSource(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it.photos,
                    prevKey = null,
                    nextKey = if (it.photos.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it)}
        )
    }

    private companion object {
        private const val FIRST_PAGE = 1
    }
}