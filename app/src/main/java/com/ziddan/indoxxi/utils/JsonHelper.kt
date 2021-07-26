package com.ziddan.indoxxi.utils

import android.content.Context
import com.ziddan.indoxxi.data.source.remote.response.FilmResponse
import com.ziddan.indoxxi.data.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadFilms(): List<FilmResponse> {
        val list = ArrayList<FilmResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("FilmResponses.json").toString())
            val listArray = responseObject.getJSONArray("films")
            for (i in 0 until listArray.length()) {
                val film = listArray.getJSONObject(i)

                val id = film.getString("showId")
                val title = film.getString("title")
                val rating = film.getDouble("rating")
                val filmRating = film.getString("filmRating")
                val duration = film.getString("duration")
                val genre = film.getString("genre")
                val released = film.getString("released")
                val description = film.getString("description")
                val director = film.getString("director")
                val writer = film.getString("writer")
                val star = film.getString("star")
                val imagePath = film.getString("imagePath")

                val filmResponse = FilmResponse(
                    id,
                    title,
                    rating,
                    filmRating,
                    duration,
                    genre,
                    released,
                    description,
                    director,
                    writer,
                    star,
                    imagePath
                )
                list.add(filmResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("showId")
                val title = tvShow.getString("title")
                val rating = tvShow.getDouble("rating")
                val filmRating = tvShow.getString("filmRating")
                val duration = tvShow.getString("duration")
                val genre = tvShow.getString("genre")
                val released = tvShow.getString("released")
                val description = tvShow.getString("description")
                val director = tvShow.getString("director")
                val writer = tvShow.getString("writer")
                val star = tvShow.getString("star")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = TvResponse(
                    id,
                    title,
                    rating,
                    filmRating,
                    duration,
                    genre,
                    released,
                    description,
                    director,
                    writer,
                    star,
                    imagePath
                )
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailFilm(filmId: String): List<FilmResponse> {
        val fileName = String.format(filmId)
        val list = ArrayList<FilmResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("films")
                for (i in 0 until listArray.length()) {
                    val film = listArray.getJSONObject(i)

                    val id = film.getString("showId")
                    val title = film.getString("title")
                    val rating = film.getDouble("rating")
                    val filmRating = film.getString("filmRating")
                    val duration = film.getString("duration")
                    val genre = film.getString("genre")
                    val released = film.getString("released")
                    val description = film.getString("description")
                    val director = film.getString("director")
                    val writer = film.getString("writer")
                    val star = film.getString("star")
                    val imagePath = film.getString("imagePath")

                    val filmResponse = FilmResponse(
                        id,
                        title,
                        rating,
                        filmRating,
                        duration,
                        genre,
                        released,
                        description,
                        director,
                        writer,
                        star,
                        imagePath
                    )
                    list.add(filmResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadDetailTv(tvId: String): List<TvResponse> {
        val fileName = String.format(tvId)
        val list = ArrayList<TvResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("tvShow")
                for (i in 0 until listArray.length()) {
                    val tvShow = listArray.getJSONObject(i)

                    val id = tvShow.getString("showId")
                    val title = tvShow.getString("title")
                    val rating = tvShow.getDouble("rating")
                    val filmRating = tvShow.getString("filmRating")
                    val duration = tvShow.getString("duration")
                    val genre = tvShow.getString("genre")
                    val released = tvShow.getString("released")
                    val description = tvShow.getString("description")
                    val director = tvShow.getString("director")
                    val writer = tvShow.getString("writer")
                    val star = tvShow.getString("star")
                    val imagePath = tvShow.getString("imagePath")

                    val tvShowResponse = TvResponse(
                        id,
                        title,
                        rating,
                        filmRating,
                        duration,
                        genre,
                        released,
                        description,
                        director,
                        writer,
                        star,
                        imagePath
                    )
                    list.add(tvShowResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}