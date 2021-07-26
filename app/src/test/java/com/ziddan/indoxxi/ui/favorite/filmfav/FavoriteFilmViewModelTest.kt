package com.ziddan.indoxxi.ui.favorite.filmfav

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
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
class FavoriteFilmViewModelTest {

    private lateinit var viewModel: FavoriteFilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteFilmViewModel(showRepository)
    }

    @Test
    fun getFavoriteFilms() {
        val dummyFilms = pagedList
        `when`(dummyFilms.size).thenReturn(10)
        val films = MutableLiveData<PagedList<ShowEntity>>()
        films.value = dummyFilms

        `when`(showRepository.getFavoritedFilms()).thenReturn(films)
        val showEntities = viewModel.getFavoriteFilms().value
        verify(showRepository).getFavoritedFilms()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getFavoriteFilms().observeForever(observer)
        verify(observer).onChanged(dummyFilms)
    }
}