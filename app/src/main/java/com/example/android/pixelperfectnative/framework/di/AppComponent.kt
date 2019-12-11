package com.example.android.pixelperfectnative.framework.di

import com.example.android.pixelperfectnative.framework.di.fragment.FragmentSubcomponent
import com.example.android.pixelperfectnative.framework.di.modules.AppModule
import com.example.android.pixelperfectnative.framework.utils.PerformanceChecker
import dagger.Component
import okhttp3.OkHttpClient

@ApplicationScope
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun getOkHttpClient(): OkHttpClient
    fun getPerformanceChecker(): PerformanceChecker
    fun getFragmentComponent(): FragmentSubcomponent
}
