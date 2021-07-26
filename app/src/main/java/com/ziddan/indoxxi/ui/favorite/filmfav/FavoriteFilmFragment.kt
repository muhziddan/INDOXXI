package com.ziddan.indoxxi.ui.favorite.filmfav

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
import com.ziddan.indoxxi.databinding.FragmentFavoriteFilmBinding
import com.ziddan.indoxxi.shows.viewmodel.ViewModelFactory

class FavoriteFilmFragment : Fragment() {

    private var _fragmentFavoriteFilmBinding: FragmentFavoriteFilmBinding? = null
    private val binding get() = _fragmentFavoriteFilmBinding

    private lateinit var viewModel: FavoriteFilmViewModel
    private lateinit var adapter: FavoriteFilmAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteFilmBinding =
            FragmentFavoriteFilmBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavFilm)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteFilmViewModel::class.java]

            adapter = FavoriteFilmAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteFilms().observe(viewLifecycleOwner, { films ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(films)
            })

            binding?.rvFavFilm?.layoutManager = GridLayoutManager(context, 2)
            binding?.rvFavFilm?.setHasFixedSize(true)
            binding?.rvFavFilm?.adapter = adapter
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
                val filmEntity = adapter.getSwipedData(swipedPosition)
                filmEntity?.let { viewModel.setFavorite(it) }
                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    filmEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}