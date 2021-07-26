package com.ziddan.indoxxi.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.databinding.*
import com.ziddan.indoxxi.shows.viewmodel.ViewModelFactory
import com.ziddan.indoxxi.vo.Status

class DetailTvActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailTvBinding
    private lateinit var activityDetailTvBinding: ActivityDetailTvBinding
    private lateinit var viewModel: DetailShowViewModel

    private var menu: Menu? = null

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvBinding.detailFilm

        setContentView(activityDetailTvBinding.root)

        setSupportActionBar(activityDetailTvBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getString(EXTRA_TV)
            if (tvId != null) {
                viewModel.setSelectedShow(tvId)

                viewModel.detailTv.observe(this, { detailTv ->
                    if (detailTv != null) {
                        when (detailTv.status) {
                            Status.LOADING -> activityDetailTvBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (detailTv.data != null) {
                                activityDetailTvBinding.progressBar.visibility = View.GONE
                                populateShow(detailTv.data)
                            }
                            Status.ERROR -> {
                                activityDetailTvBinding.progressBar.visibility = View.GONE
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

    private fun populateShow(showEntity: TvShowEntity) {
        detailContentBinding.apply {

            val director = resources.getString(R.string.director, showEntity.director)
            val writer = resources.getString(R.string.writers, showEntity.writer)
            val star = resources.getString(R.string.Stars, showEntity.star)

            tvTitle2.text = showEntity.title
            tvRating2.text = showEntity.rating.toString()
            tvFilmRating2.text = showEntity.filmRating
            tvDuration2.text = showEntity.duration
            tvGenre2.text = showEntity.genre
            tvReleased2.text = showEntity.released
            tvSynopsisDesc2.text = showEntity.description
            tvDirector2.text = director
            tvWriter2.text = writer
            tvStar2.text = star

            Glide.with(this@DetailTvActivity)
                .load(showEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.detailTv.observe(this, { detailTv ->
            if (detailTv != null) {
                when (detailTv.status) {
                    Status.LOADING -> activityDetailTvBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailTv.data != null) {
                        activityDetailTvBinding.progressBar.visibility = View.GONE
                        val state = detailTv.data.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailTvBinding.progressBar.visibility = View.GONE
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
            viewModel.setFavoriteTv()
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