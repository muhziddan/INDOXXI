package com.ziddan.indoxxi.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.vo.Resource

class TvShowViewModel(private val showRepository: ShowRepository) : ViewModel() {

    fun getShows(): LiveData<Resource<PagedList<TvShowEntity>>> = showRepository.getAllTvShows()
}