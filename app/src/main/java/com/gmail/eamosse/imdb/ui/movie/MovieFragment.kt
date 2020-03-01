package com.gmail.eamosse.imdb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs

import com.gmail.eamosse.imdb.databinding.MovieDetailFragmentBinding
import com.gmail.eamosse.imdb.ui.list_movies.MovieAdapter
import com.gmail.eamosse.imdb.ui.list_movies.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {
    private val movieViewModel: MovieViewModel by viewModel()
    private lateinit var binding: MovieDetailFragmentBinding

    private val args: MovieFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MovieFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(movieViewModel) {
            loadMovie(args.myArg)

            movie.observe(viewLifecycleOwner, Observer {
                binding.item = it
//                binding.productionCompaniesList.adapter = CompaniesAdapter(it.productionCompanies)
            })
        }
    }
}
