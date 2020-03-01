package com.gmail.eamosse.imdb.ui.list_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs

import com.gmail.eamosse.imdb.databinding.ListMoviesFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {
    private val movieViewModel: ListMoviesViewModel by viewModel()
    private lateinit var binding: ListMoviesFragmentBinding

    private val args: ListMoviesFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ListMoviesFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@ListMoviesFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*view.findViewById<TextView>(R.id.textview_home_second).text =
                getString(R.string.hello_home_second, args.myArg)

        view.findViewById<Button>(R.id.button_home_second).setOnClickListener {
            findNavController().navigate(R.id.action_HomeSecondFragment_to_HomeFragment)
        }*/

        with(movieViewModel) {
            loadMoviesFromCategory(args.myArg)

            movies.observe(viewLifecycleOwner, Observer {
                binding.categoryList.adapter =
                    MovieAdapter(it) { movie ->
                        val action =
                            ListMoviesFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(
                                movie.id
                            )
                        NavHostFragment.findNavController(this@ListMoviesFragment)
                            .navigate(action)
                    }
            })
        }
    }
}
