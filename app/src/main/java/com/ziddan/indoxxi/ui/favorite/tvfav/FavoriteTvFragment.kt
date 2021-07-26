package com.ziddan.indoxxi.ui.favorite.tvfav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.databinding.FragmentFavoriteTvBinding
import com.ziddan.indoxxi.shows.viewmodel.ViewModelFactory

class FavoriteTvFragment : Fragment() {

    private var _fragmentFavoriteTvBinding: FragmentFavoriteTvBinding? = null
    private val binding get() = _fragmentFavoriteTvBinding

    private lateinit var adapter: FavoriteTvAdapter
    private lateinit var viewModel: FavoriteTvViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteTvBinding = FragmentFavoriteTvBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavTv)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvViewModel::class.java]

            adapter = FavoriteTvAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteTvs().observe(viewLifecycleOwner, { tvs ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(tvs)
            })

            binding?.rvFavTv?.layoutManager = GridLayoutManager(context, 2)
            binding?.rvFavTv?.setHasFixedSize(true)
            binding?.rvFavTv?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvEntity = adapter.getSwipedData(swipedPosition)
                tvEntity?.let { viewModel.setFavorite(it) }
                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    tvEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}