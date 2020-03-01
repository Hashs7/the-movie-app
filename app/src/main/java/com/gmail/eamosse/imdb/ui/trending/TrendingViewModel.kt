package com.gmail.eamosse.imdb.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.*
import com.gmail.eamosse.idbdata.repository.MovieRepository
import com.gmail.eamosse.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrendingViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _trendingMovies: MutableLiveData<List<TrendingMovie>> = MutableLiveData()
    val trendingMovies: LiveData<List<TrendingMovie>>
        get() = _trendingMovies

    private val _trendingActors: MutableLiveData<List<TrendingActor>> = MutableLiveData()
    val trendingActors: LiveData<List<TrendingActor>>
        get() = _trendingActors

    init {
        loadTrendingMovies()
        loadTrendingActors()
        loadTopCategories()
    }

    private fun loadTopCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCategories()) {
                is Result.Succes -> {
                    _categories.postValue(result.data)
                }
                is Result.Error -> {
                    //_error.postValue(result.message)
                }
            }
        }
    }

    private fun loadTrendingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingMovies()) {
                is Result.Succes -> {
                    _trendingMovies.postValue(result.data)
                }
                is Result.Error -> {
                    //_error.postValue(result.message)
                }
            }
        }
    }

    private fun loadTrendingActors() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingActors()) {
                is Result.Succes -> {
                    _trendingActors.postValue(result.data)
                }
                is Result.Error -> {
                    //_error.postValue(result.message)
                }

            }
        }
    }
}