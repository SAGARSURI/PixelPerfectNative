package com.example.android.pixelperfectnative.presentation.utils

import android.content.Intent
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.android.pixelperfectnative.R

fun ImageView.load(
    url: String,
    previousUrl: String? = null,
    round: Boolean = false,
    cornersRadius: Int = 0,
    crop: Boolean = false
) {

    val requestOptions = when {
        round -> RequestOptions.circleCropTransform()
        cornersRadius > 0 -> {
            RequestOptions().transform(
                if (crop) CenterCrop() else FitCenter(),
                RoundedCorners(cornersRadius)
            )
        }
        else -> null
    }

    GlideApp
        .with(context)
        .load(url)
        .let {
            // Apply request options
            if (requestOptions != null) {
                it.apply(requestOptions)
            } else {
                it
            }
        }
        .let {
            // Workaround for the white flickering.
            // See https://github.com/bumptech/glide/issues/527
            // Thumbnail changes must be the same to catch the memory cache.
            if (previousUrl != null) {
                it.thumbnail(
                    GlideApp
                        .with(context)
                        .load(previousUrl)
                        .let {
                            // Apply request options
                            if (requestOptions != null) {
                                it.apply(requestOptions)
                            } else {
                                it
                            }
                        }
                )
            } else {
                it
            }
        }
        .into(this)
}

fun String.shareImage(fragment: Fragment) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, this@shareImage)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, fragment.getString(R.string.title_share_image))
    fragment.startActivity(shareIntent)
}
