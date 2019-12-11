package com.example.android.pixelperfectnative.framework.network

import com.example.android.core.data.PhotoDataSource
import com.example.android.core.domain.Photo
import javax.inject.Inject

class RemotePhotosSource @Inject constructor(private val apiService: UnsplashService) :
    PhotoDataSource {
    override suspend fun fetchPhotos(imageName: String): List<Photo> {
        return apiService.getImagesBySearch(query = imageName).results.map {
            Photo(
                photoUrl = it.urls.regular,
                profileUrl = it.user.profileImage.small,
                authorName = it.user.name
            )
        }
    }
}
