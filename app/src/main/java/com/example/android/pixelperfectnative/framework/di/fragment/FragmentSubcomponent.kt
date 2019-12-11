package com.example.android.pixelperfectnative.framework.di.fragment

import com.example.android.pixelperfectnative.framework.di.modules.DataSourceModule
import com.example.android.pixelperfectnative.framework.di.modules.FragmentModule
import com.example.android.pixelperfectnative.framework.di.modules.NetworkModule
import com.example.android.pixelperfectnative.framework.di.modules.UsecaseModule
import com.example.android.pixelperfectnative.framework.viewmodel.ViewModelModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        FragmentModule::class,
        ViewModelModule::class,
        UsecaseModule::class,
        NetworkModule::class,
        DataSourceModule::class
    ]
)
interface FragmentSubcomponent {
    fun inject(navHostFragment: InjectingNavHostFragment)
}
