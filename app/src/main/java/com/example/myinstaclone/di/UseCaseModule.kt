package com.example.myinstaclone.di

import com.example.domain.domain.repository.cloud.GetRepository
import com.example.domain.domain.use_case.home.FetchAllHomeScreenItemsUseCase
import com.example.domain.domain.use_case.home.FetchAllHomeScreenItemsUseCaseImpl
import com.example.domain.domain.use_case.search.FetchSearchScreenItemUseCase
import com.example.domain.domain.use_case.search.FetchSearchScreenItemUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchAllHomeScreenItemsUseCaseImpl(
        postRepository: GetRepository ,
    ): FetchAllHomeScreenItemsUseCase =
        FetchAllHomeScreenItemsUseCaseImpl(postRepository = postRepository)


    @Provides
    fun provideFetchSearchScreenItemUseCaseImpl(
        allPost: GetRepository
    ): FetchSearchScreenItemUseCase =
        FetchSearchScreenItemUseCaseImpl(allPost = allPost)
}