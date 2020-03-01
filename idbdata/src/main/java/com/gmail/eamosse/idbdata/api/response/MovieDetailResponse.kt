package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Company
import com.gmail.eamosse.idbdata.data.MovieDetail
import com.google.gson.annotations.SerializedName

internal data class MovieDetailResponse(
    @SerializedName("original_title")
    val title:String,

    @SerializedName("overview")
    val overview:String,

    @SerializedName("release_date")
    val date:String,

    @SerializedName("poster_path")
    val poster:String,

    @SerializedName("vote_average")
    val voteAverage:String,

    @SerializedName("vote_count")
    val voteCount:String,

    @SerializedName("production_companies")
    var productionCompanies: List<Company>
) {
    data class Company(
        @SerializedName("logo_path")
        val logoPath:String?,

        @SerializedName("name")
        val name:String,

        @SerializedName("origin_country")
        val originCountry:String?
    )
}

internal fun MovieDetailResponse.toMovieDetail() = MovieDetail(
    title = title,
    overview = overview,
    date = date,
    poster = poster,
    voteAverage = voteAverage,
    voteCount = voteCount,
    productionCompanies = productionCompanies.map {
        it.toCompany()
    }
)

internal fun MovieDetailResponse.Company.toCompany() = Company(
    logo_path = logoPath,
    name = name,
    origin_country = originCountry
)
