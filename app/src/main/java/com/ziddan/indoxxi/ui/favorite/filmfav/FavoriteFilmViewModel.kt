package com.ziddan.indoxxi.ui.favorite.filmfav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity

class FavoriteFilmViewModel(private val showRepository: ShowRepository) : ViewModel() {
    fun getFavoriteFilms(): LiveData<PagedList<ShowEntity>> {
        return showRepository.getFavoritedFilms()
    }

    fun setFavorite(filmEntity: ShowEntity) {
        val newState = !filmEntity.favorited
        showRepository.setFilmFavorite(filmEntity, newState)
    }
}