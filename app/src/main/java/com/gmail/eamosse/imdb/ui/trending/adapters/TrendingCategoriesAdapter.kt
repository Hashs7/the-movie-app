package com.gmail.eamosse.imdb.ui.trending.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.imdb.databinding.ItemCategoryBinding
import com.gmail.eamosse.imdb.databinding.TrendingItemActorBinding
import com.gmail.eamosse.imdb.databinding.TrendingItemCategoryBinding
import com.gmail.eamosse.imdb.ui.list_movies.ListMoviesFragment

class TrendingCategoriesAdapter(
    private val items: List<Category>,
    val handler: (category: Category) -> Unit
) :
    RecyclerView.Adapter<TrendingCategoriesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TrendingItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.item = item
            binding.root.setOnClickListener {
                handler(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: TrendingItemCategoryBinding = TrendingItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}