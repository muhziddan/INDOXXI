package com.ziddan.indoxxi.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.data.source.local.room.ShowDao

class LocalDataSource private constructor(private val mShowDao: ShowDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(showDao: ShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(showDao)
    }

    fun getAllFilms(): DataSource.Factory<Int, ShowEntity> = mShowDao.getFilms()

    fun getAllTvs(): DataSource.Factory<Int, TvShowEntity> = mShowDao.getTvShows()

    fun getFavoritedFilms(): DataSource.Factory<Int, ShowEntity> = mShowDao.getFavoritedFilm()

    fun getFavoritedTvs(): DataSource.Factory<Int, TvShowEntity> = mShowDao.getFavoritedTv()

    fun getDetailFilm(filmId: String): LiveData<ShowEntity> =
        mShowDao.getDetailFilm(filmId)

    fun getDetailTv(tvId: String): LiveData<TvShowEntity> =
        mShowDao.getDetailTv(tvId)

    fun insertFilms(films: List<ShowEntity>) = mShowDao.insertFilms(films)

    fun insertTvs(tvs: List<TvShowEntity>) = mShowDao.insertTvs(tvs)


    fun setFilmFavorite(film: ShowEntity, newState: Boolean) {
        film.favorited = newState
        mShowDao.updateFilms(film)
    }

    fun setTvFavorite(tv: TvShowEntity, newState: Boolean) {
        tv.favorited = newState
        mShowDao.updateTvs(tv)
    }
}