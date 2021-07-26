package com.ziddan.indoxxi.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ziddan.indoxxi.data.source.remote.response.FilmResponse
import com.ziddan.indoxxi.data.source.remote.response.TvResponse
import com.ziddan.indoxxi.utils.EspressoIdlingResources
import com.ziddan.indoxxi.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllFilms(): LiveData<ApiResponse<List<FilmResponse>>> {
        EspressoIdlingResources.increment()
        val resultFilm = MutableLiveData<ApiResponse<List<FilmResponse>>>()
        resultFilm.value = ApiResponse.success(jsonHelper.loadFilms())
        EspressoIdlingResources.decrement()
        return resultFilm
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResources.increment()
        val resultTv = MutableLiveData<ApiResponse<List<TvResponse>>>()
        resultTv.value = ApiResponse.success(jsonHelper.loadTvShows())
        EspressoIdlingResources.decrement()
        return resultTv
    }

    fun getDetailFilm(filmId: String): LiveData<ApiResponse<List<FilmResponse>>> {
        EspressoIdlingResources.increment()
        val resultFilms = MutableLiveData<ApiResponse<List<FilmResponse>>>()
        resultFilms.value = ApiResponse.success(jsonHelper.loadDetailFilm(filmId))
        EspressoIdlingResources.decrement()
        return resultFilms
    }

    fun getDetailTv(tvId: String): LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvs = MutableLiveData<ApiResponse<List<TvResponse>>>()
        resultTvs.value = ApiResponse.success(jsonHelper.loadDetailTv(tvId))
        EspressoIdlingResources.decrement()
        return resultTvs
    }
}