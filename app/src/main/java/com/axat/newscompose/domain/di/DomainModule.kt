package com.axat.newscompose.domain.di

import com.axat.newscompose.data.network.ApiService
import com.axat.newscompose.data.repository.GetNewsArticleRepoImpl
import com.axat.newscompose.domain.repository.GetNewsArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetNewsRepo(apiService: ApiService) : GetNewsArticleRepo {
        return GetNewsArticleRepoImpl(apiService = apiService)
    }

}