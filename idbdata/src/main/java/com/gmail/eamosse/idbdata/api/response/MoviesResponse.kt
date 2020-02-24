package com.gmail.eamosse.idbdata.api.response
import com.gmail.eamosse.idbdata.data.Company
import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

internal data class MoviesResponse(
    @SerializedName("results")
    val movies: List<Movie>
) {
    data class Movie(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
//        poster_path: null,
        @SerializedName("adult")
        val adult: Boolean,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("release_date")
        val release_date: String,
        @SerializedName("genre_ids")
        val genre_ids: List<Int>,
        @SerializedName("original_title")
        val original_title: String,
        @SerializedName("original_language")
        val original_language: String,
        @SerializedName("title")
        val title: String,
//        backdrop_path: null,
        @SerializedName("popularity")
        val popularity: Float,
        @SerializedName("vote_count")
        val vote_count: Int,
        @SerializedName("vote_average")
        val vote_average: Float,
        @SerializedName("backdrop_path")
        val backdrop_path: String,
        @SerializedName("production_companies")
        val production_companies: List<Company> ?
    )
}

internal fun MoviesResponse.Movie.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        vote_count = vote_count,
        backdrop_path = backdrop_path,
        production_companies = production_companies ?: listOf()
    )
}
