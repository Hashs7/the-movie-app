package com.gmail.eamosse.imdb.ui.trending.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.TrendingActor
import com.gmail.eamosse.imdb.databinding.TrendingItemActorBinding

class TrendingActorAdapter(private val items: List<TrendingActor>): RecyclerView.Adapter<TrendingActorAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: TrendingItemActorBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrendingActor) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: TrendingItemActorBinding = TrendingItemActorBinding.inflate(
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