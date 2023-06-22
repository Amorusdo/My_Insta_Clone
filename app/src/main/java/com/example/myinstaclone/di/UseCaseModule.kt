package com.example.myinstaclone.di

import com.example.domain.domain.use_case.home.FetchAllHomeScreenItemsUseCase
import com.example.domain.domain.use_case.home.FetchAllHomeScreenItemsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindFetchAllHomeScreenItemsUseCase(
        impl: FetchAllHomeScreenItemsUseCaseImpl
    ): FetchAllHomeScreenItemsUseCase

//    @Binds
//    abstract fun bindFetchSearchScreenItemsUseCase(
//        impl: FetchSearchScreenItemUseCaseImpl
//    ): FetchSearchScreenItemUseCase

}