package com.axat.newscompose.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(

    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String

) : Parcelable