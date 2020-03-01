package com.gmail.eamosse.imdb.ui.trending.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.TrendingMovie
import com.gmail.eamosse.imdb.databinding.TrendingItemMovieBinding

class TrendingMovieAdapter(private val items: List<TrendingMovie>): RecyclerView.Adapter<TrendingMovieAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: TrendingItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrendingMovie) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: TrendingItemMovieBinding = TrendingItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}