package com.example.android.pixelperfectnative.framework.network

import com.example.android.core.data.PhotoDataSource
import com.example.android.core.domain.PhotoModel
import javax.inject.Inject

class RemotePhotosSource @Inject constructor(private val apiService: UnsplashService) :
    PhotoDataSource {
    override suspend fun fetchPhotos(imageName: String): List<PhotoModel> {
        return apiService.getImagesBySearch(query = imageName).results.map {
            PhotoModel(
                photoUrl = it.urls.regular,
                profileUrl = it.user.profileImage.small,
                authorName = it.user.name
            )
        }
    }
}
