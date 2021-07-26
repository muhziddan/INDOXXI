package com.ziddan.indoxxi.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.utils.DataDummy
import com.ziddan.indoxxi.vo.Resource
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailShowViewModelTest {

    private lateinit var viewModel: DetailShowViewModel
    private val dummyShow = DataDummy.generateDummyShows()[0]
    private val dummyTv = DataDummy.generateDummyTv()[0]
    private val filmId = dummyShow.showId
    private val tvShowId = dummyTv.showId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var filmObserver: Observer<Resource<ShowEntity>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailShowViewModel(showRepository)
    }

    @Test
    fun getShow() {
        viewModel.setSelectedShow(dummyShow.showId)
        val dummyDetailFilms = Resource.success(DataDummy.generateDummyDetailFilm(dummyShow, true))
        val film = MutableLiveData<Resource<ShowEntity>>()
        film.value = dummyDetailFilms

        `when`(showRepository.getDetailFilms(filmId)).thenReturn(film)

        viewModel.detailFilm.observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyDetailFilms)
    }

    @Test
    fun getTv() {
        viewModel.setSelectedShow(dummyTv.showId)
        val dummyDetailTv = Resource.success(DataDummy.generateDummyDetaiTv(dummyTv, true))
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyDetailTv

        `when`(showRepository.getDetailTvShows(tvShowId)).thenReturn(tvShow)

        viewModel.detailTv.observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyDetailTv)
    }

    @Test
    fun setFavoriteFilm() {
        viewModel.setSelectedShow(dummyShow.showId)
        val dummyDetailFilmsFav =
            Resource.success(DataDummy.generateDummyDetailFilm(dummyShow, false))
        val filmFav = MutableLiveData<Resource<ShowEntity>>()
        filmFav.value = dummyDetailFilmsFav

        `when`(showRepository.getDetailFilms(filmId)).thenReturn(filmFav)
        viewModel.detailFilm = showRepository.getDetailFilms(filmId)
        viewModel.setFavoriteFilm()
        verify(showRepository)
            .setFilmFavorite(filmFav.value?.data as ShowEntity, true)
        verifyNoMoreInteractions(filmObserver)
    }

    @Test
    fun deleteFavoriteMovie() {
        viewModel.setSelectedShow(dummyShow.showId)
        val dummyDetailFilmsFav =
            Resource.success(DataDummy.generateDummyDetailFilm(dummyShow, true))
        val filmFav = MutableLiveData<Resource<ShowEntity>>()
        filmFav.value = dummyDetailFilmsFav

        `when`(showRepository.getDetailFilms(filmId)).thenReturn(filmFav)
        viewModel.detailFilm = showRepository.getDetailFilms(filmId)
        viewModel.setFavoriteFilm()
        verify(showRepository)
            .setFilmFavorite(filmFav.value?.data as ShowEntity, false)
        verifyNoMoreInteractions(filmObserver)
    }

    @Test
    fun setFavoriteTv() {
        viewModel.setSelectedShow(dummyTv.showId)
        val dummyDetailTvFav = Resource.success(DataDummy.generateDummyDetaiTv(dummyTv, false))
        val tvShowFav = MutableLiveData<Resource<TvShowEntity>>()
        tvShowFav.value = dummyDetailTvFav

        `when`(showRepository.getDetailTvShows(tvShowId)).thenReturn(tvShowFav)
        viewModel.detailTv = showRepository.getDetailTvShows(tvShowId)
        viewModel.setFavoriteTv()
        verify(showRepository).setTvFavorite(tvShowFav.value?.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvObserver)
    }

    @Test
    fun deleteFavoriteTv() {
        viewModel.setSelectedShow(dummyTv.showId)
        val dummyDetailTvFav = Resource.success(DataDummy.generateDummyDetaiTv(dummyTv, true))
        val tvShowFav = MutableLiveData<Resource<TvShowEntity>>()
        tvShowFav.value = dummyDetailTvFav

        `when`(showRepository.getDetailTvShows(tvShowId)).thenReturn(tvShowFav)
        viewModel.detailTv = showRepository.getDetailTvShows(tvShowId)
        viewModel.setFavoriteTv()
        verify(showRepository).setTvFavorite(tvShowFav.value?.data as TvShowEntity, false)
        verifyNoMoreInteractions(tvObserver)
    }
}