package com.example.android.core.usecase

import com.example.android.core.data.PhotoRepository
import com.example.android.core.domain.PhotoModel
import com.example.android.core.utils.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetSearchResult(private val photoRepository: PhotoRepository) {
    suspend operator fun invoke(imageName: String): Flow<ViewState<List<PhotoModel>>> = flow {
        emit(ViewState.Loading)
        emit(ViewState.Success(photoRepository.fetchSearchResult(imageName)))
    }.catch {
        emit(ViewState.Error(it))
    }
}
