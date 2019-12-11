package com.example.android.pixelperfectnative.framework.utils

import android.app.ActivityManager
import com.example.android.pixelperfectnative.framework.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class PerformanceChecker @Inject constructor(activityManager: ActivityManager) {

    val isHighPerformingDevice: Boolean

    init {
        isHighPerformingDevice =
            !activityManager.isLowRamDevice &&
                    Runtime.getRuntime().availableProcessors() >= OPTIMUM_CORE &&
                    activityManager.memoryClass >= OPTIMUM_MEMORY_MB
    }

    companion object {
        private const val OPTIMUM_CORE = 4
        private const val OPTIMUM_MEMORY_MB = 124
    }
}
