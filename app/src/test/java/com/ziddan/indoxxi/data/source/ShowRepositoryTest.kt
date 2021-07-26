package com.ziddan.indoxxi.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ziddan.indoxxi.LiveDataTestUtil
import com.ziddan.indoxxi.PagedListUtil
import com.ziddan.indoxxi.data.source.local.LocalDataSource
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.data.source.remote.RemoteDataSource
import com.ziddan.indoxxi.utils.AppExecutors
import com.ziddan.indoxxi.utils.DataDummy
import com.ziddan.indoxxi.vo.Resource
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import java.util.concurrent.Executor

class ShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())
    private val showRepository = FakeShowRepository(remote, local, appExecutors)

    private val filmResponses = DataDummy.generateRemoteDummyShows()
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val filmId = filmResponses[0].showId
    private val tvShowId = tvShowResponses[0].showId

    @Test
    fun getAllFilms() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllFilms()).thenReturn(dataSourceFactory)
        showRepository.getAllFilms()

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getAllFilms()
        assertNotNull(filmEntities.data)
        assertEquals(filmResponses.size.toLong(), filmEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvs()).thenReturn(dataSourceFactory)
        showRepository.getAllTvShows()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getAllTvs()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailFilms() {
        val dummyFilmEntity = MutableLiveData<ShowEntity>()
        dummyFilmEntity.value =
            DataDummy.generateDummyDetailFilm(DataDummy.generateDummyShows()[0], false)
        `when`(local.getDetailFilm(filmId)).thenReturn(dummyFilmEntity)

        val filmEntities = LiveDataTestUtil.getValue(showRepository.getDetailFilms(filmId))
        verify(local).getDetailFilm(filmId)
        assertNotNull(filmEntities.data)
        assertNotNull(filmEntities.data?.title)
        assertEquals(filmResponses[0].title, filmEntities.data?.title)
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvEntity = MutableLiveData<TvShowEntity>()
        dummyTvEntity.value = DataDummy.generateDummyDetaiTv(DataDummy.generateDummyTv()[0], false)
        `when`(local.getDetailTv(tvShowId)).thenReturn(dummyTvEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(showRepository.getDetailTvShows(tvShowId))
        verify(local).getDetailTv(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.title)
        assertEquals(tvShowResponses[0].title, tvShowEntities.data?.title)
    }

    @Test
    fun getFavoritedFilms() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getFavoritedFilms()).thenReturn(dataSourceFactory)
        showRepository.getFavoritedFilms()

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getFavoritedFilms()
        assertNotNull(filmEntities)
        assertEquals(filmResponses.size.toLong(), filmEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoritedTvs() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoritedTvs()).thenReturn(dataSourceFactory)
        showRepository.getFavoritedTvs()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getFavoritedTvs()
        assertNotNull(tvEntities)
        assertEquals(tvShowResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteFilms() {
        showRepository.setFilmFavorite(DataDummy.generateDummyShows()[0], true)
        verify(local).setFilmFavorite(DataDummy.generateDummyShows()[0], true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun deleteFavoriteFilms() {
        showRepository.setFilmFavorite(DataDummy.generateDummyShows()[0], false)
        verify(local).setFilmFavorite(DataDummy.generateDummyShows()[0], false)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteTvs() {
        showRepository.setTvFavorite(DataDummy.generateDummyTv()[0], true)
        verify(local).setTvFavorite(DataDummy.generateDummyTv()[0], true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun deleteFavoriteTvs() {
        showRepository.setTvFavorite(DataDummy.generateDummyTv()[0], false)
        verify(local).setTvFavorite(DataDummy.generateDummyTv()[0], false)
        verifyNoMoreInteractions(local)
    }

    inner class TestExecutor() : Executor {
        override fun execute(command: Runnable) {
            command.run()
        }
    }
}