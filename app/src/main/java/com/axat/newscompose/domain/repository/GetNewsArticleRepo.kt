package com.axat.newscompose.domain.repository

import com.axat.newscompose.domain.model.Article

interface GetNewsArticleRepo {

    suspend fun getNewsArticle():List<Article>

}