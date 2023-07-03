package com.example.myinstaclone.presentation.screens._search.mapper


import com.example.domain.domain.models.search.SearchPostsItemDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.screens._search.listener.ItemClickListenerSearch

interface  ItemFilteredSearchScreenMapper {
    fun map(
        items: SearchPostsItemDomain ,
        searchQuery: String ,
        postSearchItemClickListener: ItemClickListenerSearch ,
    ): Triple <List<Item> , List<Item> , List<Item>>
}
