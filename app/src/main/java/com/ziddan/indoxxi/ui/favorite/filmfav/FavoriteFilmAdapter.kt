package com.ziddan.indoxxi.ui.favorite.filmfav

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.data.source.local.entity.ShowEntity
import com.ziddan.indoxxi.databinding.ItemsFavoriteFilmBinding
import com.ziddan.indoxxi.ui.detail.DetailShowActivity

class FavoriteFilmAdapter :
    PagedListAdapter<ShowEntity, FavoriteFilmAdapter.FavFilmViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavFilmViewHolder {
        val itemsFavoriteFilmBinding =
            ItemsFavoriteFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavFilmViewHolder(itemsFavoriteFilmBinding)
    }

    override fun onBindViewHolder(holder: FavFilmViewHolder, position: Int) {
        val film = getItem(position)
        if (film != null) {
            holder.bind(film)
        }
    }

    fun getSwipedData(swipedPosition: Int): ShowEntity? = getItem(swipedPosition)

    inner class FavFilmViewHolder(private val binding: ItemsFavoriteFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: ShowEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailShowActivity::class.java)
                    intent.putExtra(DetailShowActivity.EXTRA_SHOW, film.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(film.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivFilmPoster)
            }
        }
    }
}