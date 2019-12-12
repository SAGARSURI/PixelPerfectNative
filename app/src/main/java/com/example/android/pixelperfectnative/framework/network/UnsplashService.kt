package com.example.android.pixelperfectnative.framework.network

import com.example.android.pixelperfectnative.framework.PhotoEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {

    @GET("/search/photos")
    suspend fun getImagesBySearch(
        @Query("page") page: Int = 1,
        @Query("query") query: String,
        @Query("client_id") apiKey: String = "api-key"
    ): PhotoEntity
}
