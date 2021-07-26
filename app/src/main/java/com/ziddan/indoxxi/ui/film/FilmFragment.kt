package com.ziddan.indoxxi.ui.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ziddan.indoxxi.databinding.FragmentFilmBinding
import com.ziddan.indoxxi.shows.viewmodel.ViewModelFactory
import com.ziddan.indoxxi.vo.Status

class ShowFragment : Fragment() {

    private lateinit var fragmentFilmBinding: FragmentFilmBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFilmBinding = FragmentFilmBinding.inflate(layoutInflater, container, false)
        return fragmentFilmBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[FilmViewModel::class.java]

            val filmAdapter = FilmAdapter()
            viewModel.getShows().observe(viewLifecycleOwner, { films ->
                if (films != null) {
                    when (films.status) {
                        Status.LOADING -> fragmentFilmBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentFilmBinding.progressBar.visibility = View.GONE
                            filmAdapter.submitList(films.data)
                        }
                        Status.ERROR -> {
                            fragmentFilmBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "There is an error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentFilmBinding.rvFilm) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }
}