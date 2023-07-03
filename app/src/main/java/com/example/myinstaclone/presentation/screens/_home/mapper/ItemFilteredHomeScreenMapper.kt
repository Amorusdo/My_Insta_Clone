package com.example.myinstaclone.presentation.screens._home.mapper

import com.example.domain.domain.models.user_registration.HomeScreenItemDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.lisener.UsersItemClickListener
import com.example.myinstaclone.presentation.models.user_registration.HomeScreenItemUi
import com.example.myinstaclone.presentation.screens._home.listener.ItemClickListener

interface ItemFilteredHomeScreenMapper {
    fun map(
        items: HomeScreenItemDomain ,
        searchQuery: String ,
        postItemClickListener: ItemClickListener ,
        usersItemClickListener: UsersItemClickListener
    ): Triple<List<Item> , List<Item> , List<Item>>
}
