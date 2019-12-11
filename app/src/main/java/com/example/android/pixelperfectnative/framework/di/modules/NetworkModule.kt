package com.example.android.pixelperfectnative.framework.di.modules

import com.example.android.core.data.PhotoDataSource
import com.example.android.core.data.PhotoRepository
import com.example.android.pixelperfectnative.framework.network.UnsplashService
import com.example.android.pixelperfectnative.framework.utils.DefaultDispatcherProvider
import com.example.android.pixelperfectnative.framework.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object NetworkModule {
    @Provides
    @JvmStatic
    fun photoService(retrofit: Retrofit) = retrofit.create(UnsplashService::class.java)

    @Provides
    @JvmStatic
    fun providePhotoRepository(remotePhotosSource: PhotoDataSource): PhotoRepository {
        return PhotoRepository(remotePhotosSource)
    }

    @Provides
    @JvmStatic
    fun provideDispatcher(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }
}
