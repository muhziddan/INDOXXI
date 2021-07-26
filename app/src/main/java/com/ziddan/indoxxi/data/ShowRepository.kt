package com.ziddan.indoxxi.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ziddan.indoxxi.data.source.local.LocalDataSource
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.data.source.remote.ApiResponse
import com.ziddan.indoxxi.data.source.remote.RemoteDataSource
import com.ziddan.indoxxi.data.source.remote.response.FilmResponse
import com.ziddan.indoxxi.data.source.remote.response.TvResponse
import com.ziddan.indoxxi.utils.AppExecutors
import com.ziddan.indoxxi.vo.Resource

class ShowRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ShowDataSource {

    companion object {
        @Volatile
        private var instance: ShowRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): ShowRepository =
            instance ?: synchronized(this) {
                instance ?: ShowRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllFilms(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ShowEntity>, List<FilmResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllFilms(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<FilmResponse>>> =
                remoteDataSource.getAllFilms()

            public override fun saveCallResult(filmResponses: List<FilmResponse>) {
                val filmList = ArrayList<ShowEntity>()
                for (response in filmResponses) {
                    val film = ShowEntity(
                        response.showId,
                        response.title,
                        response.rating,
                        response.filmRating,
                        response.duration,
                        response.genre,
                        response.released,
                        response.description,
                        response.director,
                        response.writer,
                        response.star,
                        false,
                        response.imagePath
                    )
                    filmList.add(film)
                }
                localDataSource.insertFilms(filmList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvs(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getAllTvShows()

            public override fun saveCallResult(tvResponses: List<TvResponse>) {
                val tvList = ArrayList<TvShowEntity>()
                for (response in tvResponses) {
                    val tvShow = TvShowEntity(
                        response.showId,
                        response.title,
                        response.rating,
                        response.filmRating,
                        response.duration,
                        response.genre,
                        response.released,
                        response.description,
                        response.director,
                        response.writer,
                        response.star,
                        false,
                        response.imagePath
                    )
                    tvList.add(tvShow)
                }
                localDataSource.insertTvs(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailFilms(filmId: String): LiveData<Resource<ShowEntity>> {
        return object : NetworkBoundResource<ShowEntity, List<FilmResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowEntity> =
                localDataSource.getDetailFilm(filmId)

            override fun shouldFetch(detailFilm: ShowEntity?): Boolean =
                detailFilm == null || detailFilm.showId.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<FilmResponse>>> =
                remoteDataSource.getDetailFilm(filmId)

            override fun saveCallResult(filmResponses: List<FilmResponse>) {
                val filmList = ArrayList<ShowEntity>()
                for (response in filmResponses) {
                    val film = ShowEntity(
                        response.showId,
                        response.title,
                        response.rating,
                        response.filmRating,
                        response.duration,
                        response.genre,
                        response.released,
                        response.description,
                        response.director,
                        response.writer,
                        response.star,
                        false,
                        response.imagePath
                    )
                    filmList.add(film)
                }
                localDataSource.insertFilms(filmList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShows(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTv(tvShowId)

            override fun shouldFetch(detailTv: TvShowEntity?): Boolean =
                detailTv == null || detailTv.showId.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getDetailTv(tvShowId)

            override fun saveCallResult(tvResponses: List<TvResponse>) {
                val tvList = ArrayList<TvShowEntity>()
                for (response in tvResponses) {
                    val tvShow = TvShowEntity(
                        response.showId,
                        response.title,
                        response.rating,
                        response.filmRating,
                        response.duration,
                        response.genre,
                        response.released,
                        response.description,
                        response.director,
                        response.writer,
                        response.star,
                        false,
                        response.imagePath
                    )
                    tvList.add(tvShow)
                }
                localDataSource.insertTvs(tvList)
            }
        }.asLiveData()
    }


    override fun getFavoritedFilms(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedFilms(), config).build()
    }

    override fun getFavoritedTvs(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedTvs(), config).build()
    }

    override fun setFilmFavorite(film: ShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFilmFavorite(film, state) }

    override fun setTvFavorite(tv: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvFavorite(tv, state) }
}