package com.ziddan.indoxxi.ui.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.vo.Resource

class FilmViewModel(private val showRepository: ShowRepository) : ViewModel() {

    fun getShows(): LiveData<Resource<PagedList<ShowEntity>>> = showRepository.getAllFilms()
}