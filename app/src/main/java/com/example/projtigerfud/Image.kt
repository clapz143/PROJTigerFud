package com.example.projtigerfud

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val imageSrc: Int,
    val activityClass: Class<*>
) : Parcelable