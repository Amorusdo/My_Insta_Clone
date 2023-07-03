package com.example.myinstaclone.di

import com.example.data.repositoryImpl.cloud.GetRepositoryImpl
import com.example.data.repositoryImpl.storage.UserStorageRepositoryData
import com.example.data.repositoryImpl.storage.UserStorageRepositoryImpl
import com.example.domain.domain.repository.cloud.GetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryBindsModule {

    @Binds
    abstract fun bindGetRepository(
        impl: GetRepositoryImpl
    ): GetRepository

//    @Binds
//    abstract fun bindStorageDataSource(
//        impl: StorageDataSourceImpl
//    ): StorageDataSource

    @Binds
    abstract fun bindUserStorageRepository(
        impl: UserStorageRepositoryImpl
    ): UserStorageRepositoryData


}