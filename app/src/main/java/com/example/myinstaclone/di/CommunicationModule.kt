package com.example.myinstaclone.di

import com.example.myinstaclone.presentation.utils.communication_from_navigation.NavigationCommunication
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommunicationModule {

    @Binds
    abstract fun bindNavigationCommunication(
        impl: NavigationCommunication.Base
    ): NavigationCommunication
}