package com.ziddan.indoxxi.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShowEntities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var showId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "filmRating")
    var filmRating: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "director")
    var director: String,

    @ColumnInfo(name = "writer")
    var writer: String,

    @ColumnInfo(name = "star")
    var star: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String
)