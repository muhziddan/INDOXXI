package com.ziddan.indoxxi.ui.favorite.tvfav

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.data.source.local.entity.TvShowEntity
import com.ziddan.indoxxi.databinding.ItemsFavoriteTvBinding
import com.ziddan.indoxxi.ui.detail.DetailTvActivity

class FavoriteTvAdapter :
    PagedListAdapter<TvShowEntity, FavoriteTvAdapter.FavTvViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavTvViewHolder {
        val itemsFavoriteTvBinding =
            ItemsFavoriteTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavTvViewHolder(itemsFavoriteTvBinding)
    }

    override fun onBindViewHolder(holder: FavTvViewHolder, position: Int) {
        val tv = getItem(position)
        if (tv != null) {
            holder.bind(tv)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    inner class FavTvViewHolder(private val binding: ItemsFavoriteTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvShowEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_TV, tv.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tv.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivTvPoster)
            }
        }
    }
}