package com.example.android.core.data

import com.example.android.core.domain.PhotoModel

class PhotoRepository(private val photoDataSource: PhotoDataSource) {
    suspend fun fetchSearchResult(imageName: String): List<PhotoModel> =
        photoDataSource.fetchPhotos(imageName)
}
