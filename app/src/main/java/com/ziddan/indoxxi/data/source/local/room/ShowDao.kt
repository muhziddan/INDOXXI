package com.ziddan.indoxxi.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity

@Dao
interface ShowDao {

    @Query("SELECT * FROM showEntities")
    fun getFilms(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM tvShowEntities")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM showEntities where favorited = 1")
    fun getFavoritedFilm(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM tvShowEntities where favorited = 1")
    fun getFavoritedTv(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM showEntities WHERE showId = :showId")
    fun getDetailFilm(showId: String): LiveData<ShowEntity>

    @Transaction
    @Query("SELECT * FROM tvShowEntities WHERE tvShowId = :tvShowId")
    fun getDetailTv(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(films: List<ShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvs(tvs: List<TvShowEntity>)

    @Update
    fun updateFilms(films: ShowEntity)

    @Update
    fun updateTvs(tvs: TvShowEntity)
}