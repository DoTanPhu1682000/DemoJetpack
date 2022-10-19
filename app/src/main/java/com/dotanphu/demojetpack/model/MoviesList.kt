package com.dotanphu.demojetpack.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviesList(
    val page: Int,
    @SerializedName("results")
    @Expose
    val movies: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)