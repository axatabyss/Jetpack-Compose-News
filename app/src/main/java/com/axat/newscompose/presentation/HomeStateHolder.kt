package com.axat.newscompose.presentation

import com.axat.newscompose.domain.model.Article

data class HomeStateHolder(

    val isLoading : Boolean = false,
    val data : List<Article>? = null,
    val error : String = ""

)