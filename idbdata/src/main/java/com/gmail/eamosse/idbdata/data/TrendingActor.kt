package com.gmail.eamosse.idbdata.data

data class TrendingActor(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val name: String,
    val popularity: Double,
    val profile_path: String
)