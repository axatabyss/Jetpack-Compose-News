package com.axat.newscompose.mappers

import com.axat.newscompose.data.model.ArticleDTO
import com.axat.newscompose.domain.model.Article

fun List<ArticleDTO>.toDomain():List<Article>{
    return map{
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}