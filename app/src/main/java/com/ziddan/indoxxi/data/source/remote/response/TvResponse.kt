package com.ziddan.indoxxi.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
    var showId: String,
    var title: String,
    var rating: Double,
    var filmRating: String,
    var duration: String,
    var genre: String,
    var released: String,
    var description: String,
    var director: String,
    var writer: String,
    var star: String,
    var imagePath: String
) : Parcelable