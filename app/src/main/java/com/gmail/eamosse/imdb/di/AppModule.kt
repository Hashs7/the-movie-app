package com.gmail.eamosse.imdb.di

import android.content.Context
import com.gmail.eamosse.imdb.ui.home.HomeViewModel
import com.gmail.eamosse.imdb.ui.list_movies.ListMoviesViewModel
import com.gmail.eamosse.imdb.ui.list_movies.MovieViewModel
import com.gmail.eamosse.imdb.ui.trending.TrendingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("API_KEY")) {
        "79106c0330febc2941340adb1c0489c0"
    }

    single(named("BASE_URL")) {
        "https://api.themoviedb.org/3/"
    }

    single(named("APP_PREFS")) {
        androidContext().getSharedPreferences("app_private", Context.MODE_PRIVATE)
    }

    viewModel {
        HomeViewModel(repository = get())
    }

    viewModel {
        ListMoviesViewModel(repository = get())
    }

    viewModel {
        MovieViewModel(repository = get())
    }

    viewModel {
        TrendingViewModel(repository = get())
    }
}