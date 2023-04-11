package com.axat.newscompose.di

import com.axat.newscompose.repository.RemoteDS
import com.axat.newscompose.repository.RemoteDSImpl
import com.axat.newscompose.repository.Repo
import com.axat.newscompose.repository.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindRemoteDS(remoteDsImpl: RemoteDSImpl): RemoteDS

    @Binds
    abstract fun bindRepo(repoImpl: RepoImpl): Repo
}