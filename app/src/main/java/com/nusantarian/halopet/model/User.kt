package com.nusantarian.halopet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val Email: String,
    val pass: String,
    val Name: String?,
    val confirm: String?
) :Parcelable