package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyContact (
    val huruf: String = "",
    val kata: String = "") : Parcelable