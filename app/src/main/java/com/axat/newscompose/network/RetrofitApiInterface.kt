package com.axat.newscompose.network

import com.axat.newscompose.model.IpInfoResponse
import com.axat.newscompose.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface RetrofitApiInterface {

    @GET
    suspend fun getIpInfo(@Url url: String): IpInfoResponse

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String, @Query("country") countryCode: String, @Query("category") category: String
    ): NewsResponse

    @GET("/v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String, @Query("q") query: String
    ): NewsResponse

}