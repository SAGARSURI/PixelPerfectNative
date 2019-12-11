package com.example.android.pixelperfectnative.presentation.utils

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.android.pixelperfectnative.framework.PixelPerfectApplication
import java.io.InputStream

@GlideModule
class PixelPerfectNativeGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        val client = PixelPerfectApplication.component.getOkHttpClient()
        val devicePerformance = PixelPerfectApplication.component.getPerformanceChecker()
        if (devicePerformance.isHighPerformingDevice) {
            glide.setMemoryCategory(MemoryCategory.NORMAL)
        } else {
            glide.setMemoryCategory(MemoryCategory.LOW)
        }
        registry.append(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(client)
        )
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val performanceDetect = PixelPerfectApplication.component.getPerformanceChecker()
        if (performanceDetect.isHighPerformingDevice) {
            builder.setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888))
        } else {
            builder.setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_RGB_565))
        }
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}
