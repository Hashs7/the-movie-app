package com.gmail.eamosse.idbdata.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,
    val title: String,
    val overview: String,
    val backdrop_path: String,
    val vote_count: Int,
    val production_companies: List<Company>
)