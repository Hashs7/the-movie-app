package com.gmail.eamosse.idbdata.data

data class MovieDetail (
    val title:String,
    val overview:String,
    val date:String,
    val poster:String?,
    val voteAverage:String,
    val voteCount:String,
    val productionCompanies:List<Company>
)