package com.dotanphu.demojetpack.network

import com.dotanphu.demojetpack.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/movie/popular?api_key=e7631ffcb8e766993e5ec0c1f4245f93")
    suspend fun getPage(@Query("page") page: Int) : Response<MoviesList>

}