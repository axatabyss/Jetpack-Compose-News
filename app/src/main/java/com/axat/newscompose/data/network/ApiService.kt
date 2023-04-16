package com.axat.newscompose.data.network

import com.axat.newscompose.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country:String="us",
        @Query("apiKey") apiKey:String="436a7b507ee5433bafa1ad67c8eff93b"
    ): Response<NewsDTO>

}