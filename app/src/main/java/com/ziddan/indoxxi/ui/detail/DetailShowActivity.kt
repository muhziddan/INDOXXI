package com.ziddan.indoxxi.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.databinding.ActivityDetailShowBinding
import com.ziddan.indoxxi.databinding.ContentDetailShowBinding
import com.ziddan.indoxxi.shows.viewmodel.ViewModelFactory
import com.ziddan.indoxxi.vo.Status

class DetailShowActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailShowBinding
    private lateinit var activityDetailShowBinding: ActivityDetailShowBinding
    private lateinit var viewModel: DetailShowViewModel

    private var menu: Menu? = null

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailShowBinding = ActivityDetailShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailShowBinding.detailContent

        setContentView(activityDetailShowBinding.root)

        setSupportActionBar(activityDetailShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val filmId = extras.getString(EXTRA_SHOW)
            if (filmId != null) {
                viewModel.setSelectedShow(filmId)

                viewModel.detailFilm.observe(this, { detailFilm ->
                    if (detailFilm != null) {
                        when (detailFilm.status) {
                            Status.LOADING -> activityDetailShowBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (detailFilm.data != null) {
                                activityDetailShowBinding.progressBar.visibility = View.GONE
                                populateShow(detailFilm.data)
                            }
                            Status.ERROR -> {
                                activityDetailShowBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "There is an error",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateShow(showEntity: ShowEntity) {
        detailContentBinding.apply {

            val director = resources.getString(R.string.director, showEntity.director)
            val writer = resources.getString(R.string.writers, showEntity.writer)
            val star = resources.getString(R.string.Stars, showEntity.star)

            tvTitle.text = showEntity.title
            tvRating.text = showEntity.rating.toString()
            tvFilmRating.text = showEntity.filmRating
            tvDuration.text = showEntity.duration
            tvGenre.text = showEntity.genre
            tvReleased.text = showEntity.released
            tvSynopsisDesc.text = showEntity.description
            tvDirector.text = director
            tvWriter.text = writer
            tvStar.text = star

            Glide.with(this@DetailShowActivity)
                .load(showEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.detailFilm.observe(this, { detailFilm ->
            if (detailFilm != null) {
                when (detailFilm.status) {
                    Status.LOADING -> activityDetailShowBinding.progressBar.visibility =
                        View.VISIBLE
                    Status.SUCCESS -> if (detailFilm.data != null) {
                        activityDetailShowBinding.progressBar.visibility = View.GONE
                        val state = detailFilm.data.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "There is an error", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavoriteFilm()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorited_24)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }
}