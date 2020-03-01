package com.gmail.eamosse.imdb.ui.list_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.Movie
import com.gmail.eamosse.idbdata.data.Token
import com.gmail.eamosse.idbdata.repository.MovieRepository
import com.gmail.eamosse.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    val movie: LiveData<Movie>
        get() = _movie


    fun loadMovie(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getMoviesFromCategory(id)) {
                is Result.Succes -> {
                    _movie.postValue(result.data[0])
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }
}