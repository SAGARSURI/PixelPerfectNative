package com.example.android.pixelperfectnative.presentation.ui

import androidx.lifecycle.*
import com.example.android.core.domain.Photo
import com.example.android.core.utils.ViewState
import com.example.android.pixelperfectnative.framework.Interactor
import com.example.android.pixelperfectnative.framework.utils.DispatcherProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
    private val interactor: Interactor,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    private var job: Job? = null
    private val _mediatorLiveData = MediatorLiveData<ViewState<List<Photo>>>()
    val photosLiveData: LiveData<ViewState<List<Photo>>>
        get() = _mediatorLiveData

    fun onSearchTextChanged(searchText: CharSequence) {
        job?.cancel()
        fetchImageList(searchText.toString())
    }

    private fun fetchImageList(searchText: String) {
        if (searchText.isNotBlank()) {
            job = viewModelScope.launch {
                delay(300)
                updatePhotoLiveData(downloadPhotosData(interactor, searchText))
            }
        } else {
            updatePhotoLiveData(loadEmptyList())
        }
    }

    private fun loadEmptyList(): Flow<ViewState<List<Photo>>> {
        return flow {
            emit(ViewState.Success(emptyList<Photo>()))
        }
    }

    private suspend fun downloadPhotosData(
        interactor: Interactor,
        searchText: String
    ): Flow<ViewState<List<Photo>>> {
        return interactor.getSearchResult(searchText)
    }

    private fun updatePhotoLiveData(result: Flow<ViewState<List<Photo>>>) {
        _mediatorLiveData.addSource(result.asLiveData()) {
            _mediatorLiveData.value = it
        }
    }

}
