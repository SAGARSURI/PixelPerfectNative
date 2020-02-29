package com.example.android.core.data

import com.example.android.core.domain.PhotoModel

interface PhotoDataSource {
    suspend fun fetchPhotos(imageName: String): List<PhotoModel>
}
