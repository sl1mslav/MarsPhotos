package com.example.a14hw.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.a14hw.domain.GetMarsPhotosUseCase
import com.example.a14hw.entity.MarsPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val marsPhotosUseCase: GetMarsPhotosUseCase
) : ViewModel() {

    init {
        fetchMarsPhotosFlow()
    }

    fun fetchMarsPhotosFlow(): Flow<PagingData<MarsPhoto>> {
        return marsPhotosUseCase.execute().cachedIn(viewModelScope)
    }
}