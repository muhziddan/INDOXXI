package com.ziddan.indoxxi.ui.film

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = FilmViewModel(showRepository)
    }

    @Test
    fun getShows() {
        val dummyFilm = Resource.success(pagedList)
        `when`(dummyFilm.data?.size).thenReturn(10)
        val films = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        films.value = dummyFilm

        `when`(showRepository.getAllFilms()).thenReturn(films)
        val showEntities = viewModel.getShows().value?.data
        verify(showRepository).getAllFilms()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyFilm)
    }
}