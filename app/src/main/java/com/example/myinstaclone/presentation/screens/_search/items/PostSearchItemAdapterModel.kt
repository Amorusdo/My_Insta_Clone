package com.example.myinstaclone.presentation.screens._search.items

import com.example.myinstaclone.presentation.screens._search.listener.ItemClickListenerSearch
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.models.user_post.PostUi


data class PostSearchItemAdapterModel(
    val posts: PostUi ,
    val listener: ItemClickListenerSearch ,
) : Item {
    fun id() = posts.postId
}