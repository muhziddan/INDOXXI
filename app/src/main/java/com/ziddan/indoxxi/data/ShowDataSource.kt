package com.ziddan.indoxxi.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.vo.Resource

interface ShowDataSource {

    fun getAllFilms(): LiveData<Resource<PagedList<ShowEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailFilms(filmId: String): LiveData<Resource<ShowEntity>>

    fun getDetailTvShows(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoritedFilms(): LiveData<PagedList<ShowEntity>>

    fun getFavoritedTvs(): LiveData<PagedList<TvShowEntity>>

    fun setFilmFavorite(film: ShowEntity, state: Boolean)

    fun setTvFavorite(tv: TvShowEntity, state: Boolean)
}