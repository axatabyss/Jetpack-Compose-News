package com.axat.newscompose.data.repository

import com.axat.newscompose.data.network.ApiService
import com.axat.newscompose.domain.model.Article
import com.axat.newscompose.domain.repository.GetNewsArticleRepo
import com.axat.newscompose.mappers.toDomain
import com.axat.newscompose.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepoImpl
@Inject constructor(private val apiService: ApiService) : GetNewsArticleRepo, SafeApiRequest(){

    override suspend fun getNewsArticle(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticles() }
        return response.articles?.toDomain()!!
    }

}