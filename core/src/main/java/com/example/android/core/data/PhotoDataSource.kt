package com.example.android.core.data

import com.example.android.core.domain.Photo

interface PhotoDataSource {
    suspend fun fetchPhotos(imageName: String): List<Photo>
}
