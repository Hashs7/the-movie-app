package com.gmail.eamosse.imdb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.gmail.eamosse.imdb.databinding.MovieDetailFragmentBinding
import com.gmail.eamosse.imdb.ui.list_movies.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {
    private val listMoviesViewModel: MovieViewModel by viewModel()
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

        with(listMoviesViewModel) {
            /*loadMoviesFromCategory(args.myArg)

            movies.observe(viewLifecycleOwner, Observer {
                binding.categoryList.adapter =
                    MovieAdapter(it) { movie ->
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToMoviesListFragment(
                                movie.id
                            )
                        NavHostFragment.findNavController(this@ListMoviesFragment)
                            .navigate(action)
                    }
            })*/
        }
    }
}
