package com.example.myinstaclone.presentation.screens._comment.items

import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.screens._comment.mapper.listener.ItemClickListenerComment


data class CommentItemAdapterModel(
    val comments: UserCommentsUi ,
    val listener: ItemClickListenerComment ,
) : Item {
    fun id() = comments.idPostForComments
}