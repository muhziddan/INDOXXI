package com.ziddan.indoxxi.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.vo.Resource

class DetailShowViewModel(private val showRepository: ShowRepository) : ViewModel() {
    val showId = MutableLiveData<String>()

    fun setSelectedShow(showId: String) {
        this.showId.value = showId
    }

    var detailFilm: LiveData<Resource<ShowEntity>> = Transformations.switchMap(showId) { mFilmId ->
        showRepository.getDetailFilms(mFilmId)
    }

    var detailTv: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(showId) { mTvId ->
        showRepository.getDetailTvShows(mTvId)
    }

    fun setFavoriteFilm() {
        val filmResource = detailFilm.value
        if (filmResource != null) {
            val detailFavFilm = filmResource.data
            if (detailFavFilm != null) {
                val newState = !detailFavFilm.favorited
                showRepository.setFilmFavorite(detailFavFilm, newState)
            }
        }
    }

    fun setFavoriteTv() {
        val tvResource = detailTv.value
        if (tvResource != null) {
            val detailFavTv = tvResource.data
            if (detailFavTv != null) {
                val newState = !detailFavTv.favorited
                showRepository.setTvFavorite(detailFavTv, newState)
            }
        }
    }
}