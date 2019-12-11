package com.example.android.pixelperfectnative.framework.di.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.android.pixelperfectnative.framework.di.fragment.FragmentKey
import com.example.android.pixelperfectnative.framework.di.fragment.InjectingFragmentFactory
import com.example.android.pixelperfectnative.presentation.ui.PhotosFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentModule {

    @Binds
    abstract fun provideFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(value = PhotosFragment::class)
    abstract fun providePhotosFragment(fragment: PhotosFragment): Fragment
}
