package com.example.android.core.data

import com.example.android.core.domain.Photo

class PhotoRepository(private val photoDataSource: PhotoDataSource) {
    suspend fun fetchSearchResult(imageName: String): List<Photo> =
        photoDataSource.fetchPhotos(imageName)
}
