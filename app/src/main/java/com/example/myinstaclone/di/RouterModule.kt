package com.example.myinstaclone.di

import com.example.myinstaclone.presentation.screens._home.router.HomeScreenRouter
import com.example.myinstaclone.presentation.screens._home.router.HomeScreenRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RouterModule {

    @Binds
    abstract fun bindHomeScreenRouter(
        impl: HomeScreenRouterImpl
    ): HomeScreenRouter

}