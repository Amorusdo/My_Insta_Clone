package com.example.myinstaclone.di

import com.example.myinstaclone.presentation.screens._home.mapper.ItemFilteredHomeScreenMapper
import com.example.myinstaclone.presentation.screens._home.mapper.ItemHomeScreenMapperImpl
import com.example.myinstaclone.presentation.screens._search.mapper.ItemFilteredSearchScreenMapper
import com.example.myinstaclone.presentation.screens._search.mapper.ItemSearchScreenMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilteredMapperModule {

    @Binds
    abstract fun bindItemFilteredHomeScreenMapper(
        impl: ItemHomeScreenMapperImpl
    ): ItemFilteredHomeScreenMapper

    @Binds
    abstract fun bindItemFilteredSearchScreenMapper(
        impl: ItemSearchScreenMapperImpl
    ): ItemFilteredSearchScreenMapper

}