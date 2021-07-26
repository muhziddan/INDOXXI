package com.ziddan.indoxxi.ui.favorite.tvfav

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.ui.favorite.filmfav.FavoriteFilmViewModel
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
class FavoriteTvViewModelTest {

    private lateinit var viewModel: FavoriteTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvViewModel(showRepository)
    }

    @Test
    fun getFavoriteTvs() {
        val dummyTvs = pagedList
        `when`(dummyTvs.size).thenReturn(10)
        val tvs = MutableLiveData<PagedList<TvShowEntity>>()
        tvs.value = dummyTvs

        `when`(showRepository.getFavoritedTvs()).thenReturn(tvs)
        val tvEntities = viewModel.getFavoriteTvs().value
        verify(showRepository).getFavoritedTvs()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getFavoriteTvs().observeForever(observer)
        verify(observer).onChanged(dummyTvs)
    }
}