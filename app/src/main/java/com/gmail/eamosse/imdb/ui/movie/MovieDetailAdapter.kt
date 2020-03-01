package com.gmail.eamosse.imdb.ui.list_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.Movie
import com.gmail.eamosse.imdb.databinding.ItemCategoryBinding
import com.gmail.eamosse.imdb.databinding.ItemMovieBinding
import com.gmail.eamosse.imdb.ui.list_movies.ListMoviesFragment

class MovieDetailAdapter(private val items: Movie) :
    RecyclerView.Adapter<MovieDetailAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemMovieBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items)
    }
}