package com.example.android.pixelperfectnative.framework.di.modules

import com.example.android.core.data.PhotoDataSource
import com.example.android.pixelperfectnative.framework.network.RemotePhotosSource
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun providePhotoDataSource(remotePhotosSource: RemotePhotosSource): PhotoDataSource
}
