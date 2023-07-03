package com.example.myinstaclone.presentation.screens._comment.mapper

import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.screens._comment.mapper.listener.ItemClickListenerComment

interface ItemFilteredCommentMapper {
    fun map(
        items: GetResponseListCommentsDomain ,
        searchQuery: String ,
        commentItemClickListener: ItemClickListenerComment ,
        ): Triple<List<Item> , List<Item> , List<Item>>
}
