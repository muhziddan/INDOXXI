package com.ziddan.indoxxi.shows.di

import android.content.Context
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.LocalDataSource
import com.ziddan.indoxxi.data.source.local.room.ShowDatabase
import com.ziddan.indoxxi.data.source.remote.RemoteDataSource
import com.ziddan.indoxxi.utils.AppExecutors
import com.ziddan.indoxxi.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ShowRepository {

        val database = ShowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.showDao())
        val appExecutors = AppExecutors()

        return ShowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}