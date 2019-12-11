package com.example.android.pixelperfectnative.framework.di.modules

import com.example.android.core.data.PhotoRepository
import com.example.android.core.usecase.GetSearchResult
import com.example.android.pixelperfectnative.framework.Interactor
import dagger.Module
import dagger.Provides

@Module
object UsecaseModule {

    @Provides
    @JvmStatic
    fun provideInteractor(getSearchResult: GetSearchResult) = Interactor(getSearchResult)

    @Provides
    @JvmStatic
    fun provideGetSearchResultUsecase(photoRepository: PhotoRepository) =
        GetSearchResult(photoRepository = photoRepository)
}
