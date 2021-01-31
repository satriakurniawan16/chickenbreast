package com.satriakurniawan.chickenbreastrecipe.ui.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MainModel(
    var id: String,
    var image: String,
    var title: String
) : Parcelable