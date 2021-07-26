package com.ziddan.indoxxi.ui.favorite.tvfav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity

class FavoriteTvViewModel(private val showRepository: ShowRepository) : ViewModel() {
    fun getFavoriteTvs(): LiveData<PagedList<TvShowEntity>> {
        return showRepository.getFavoritedTvs()
    }

    fun setFavorite(tvEntity: TvShowEntity) {
        val newState = !tvEntity.favorited
        showRepository.setTvFavorite(tvEntity, newState)
    }
}