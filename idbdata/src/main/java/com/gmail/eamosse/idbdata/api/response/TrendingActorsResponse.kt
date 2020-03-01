package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.TrendingActor

internal data class TrendingActorsResponse(
    val page: Int,
    val results: List<Actor>
) {
    data class Actor(
        val adult: Boolean,
        val gender: Int,
        val id: Int,
        val known_for: List<KnownFor>,
        val known_for_department: String,
        val media_type: String,
        val name: String,
        val popularity: Double,
        val profile_path: String
    )
    data class KnownFor(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val media_type: String,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    )
}

internal fun TrendingActorsResponse.Actor.toActor() = TrendingActor(
    adult = adult,
    id = id,
    name = name,
    gender = gender,
    popularity = popularity,
    profile_path = profile_path
)