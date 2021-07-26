package com.ziddan.indoxxi.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity

@Database(
    entities = [ShowEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ShowDatabase : RoomDatabase() {
    abstract fun showDao(): ShowDao

    companion object {

        @Volatile
        private var INSTANCE: ShowDatabase? = null

        fun getInstance(context: Context): ShowDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ShowDatabase::class.java,
                    "Academies.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}