package com.example.android.pixelperfectnative.framework.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val photoUrl: String,
    val profileUrl: String,
    val authorName: String
): Parcelable