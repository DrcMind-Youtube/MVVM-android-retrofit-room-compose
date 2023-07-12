package com.drcmind.androidretrofitroomjetpackcompose.data.datasource.remote

import com.drcmind.androidretrofitroomjetpackcompose.domain.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {
    @GET("/api")
    suspend fun getRandomJoke(
        @Query("format") format : String = "json"
    ) : Response<JokeResponse>
}