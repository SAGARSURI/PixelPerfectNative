package com.example.android.pixelperfectnative.framework

import android.app.Application
import com.example.android.pixelperfectnative.framework.di.AppComponent
import com.example.android.pixelperfectnative.framework.di.DaggerAppComponent
import com.example.android.pixelperfectnative.framework.di.modules.AppModule

class PixelPerfectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}
