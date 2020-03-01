package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.TrendingMovie
import com.google.gson.annotations.SerializedName

data class TrendingMoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("adult")
        val adult: Boolean,
        @SerializedName("backdrop_path")
        val backdrop_path: String,
        @SerializedName("genre_ids")
        val genre_ids: List<Int>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_language")
        val original_language: String,
        @SerializedName("original_title")
        val original_title: String?,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("poster_path")
        val poster_path: String,
        @SerializedName("release_date")
        val release_date: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("video")
        val video: Boolean,
        @SerializedName("vote_average")
        val vote_average: Double,
        @SerializedName("vote_count")
        val vote_count: Int
    )
}

internal fun TrendingMoviesResponse.Result.toMovie() = TrendingMovie(
    adult = adult,
    original_title = original_title ?: "",
    title = title ?: "",
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    id = id,
    overview = overview,
    release_date = release_date ?: ""
)