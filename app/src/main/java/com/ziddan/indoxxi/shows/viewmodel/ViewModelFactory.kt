package com.ziddan.indoxxi.shows.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ziddan.indoxxi.data.ShowRepository
import com.ziddan.indoxxi.shows.di.Injection
import com.ziddan.indoxxi.ui.detail.DetailShowViewModel
import com.ziddan.indoxxi.ui.favorite.filmfav.FavoriteFilmViewModel
import com.ziddan.indoxxi.ui.favorite.tvfav.FavoriteTvViewModel
import com.ziddan.indoxxi.ui.film.FilmViewModel
import com.ziddan.indoxxi.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mShowRepository: ShowRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(FilmViewModel::class.java) -> {
                return FilmViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailShowViewModel::class.java) -> {
                return DetailShowViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteFilmViewModel::class.java) -> {
                return FavoriteFilmViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvViewModel::class.java) -> {
                return FavoriteTvViewModel(mShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}