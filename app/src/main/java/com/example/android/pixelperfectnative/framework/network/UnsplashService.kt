package com.example.android.pixelperfectnative.framework.network

import com.example.android.pixelperfectnative.framework.PhotoEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {

    @GET("/search/photos")
    suspend fun getImagesBySearch(
        @Query("page") page: Int = 1,
        @Query("query") query: String,
        @Query("client_id") apiKey: String = "f479ec080c34ba3fa66a8976117b5a99b030528ae1a0be2df5f8de83525bfbfe"
    ): PhotoEntity
}
