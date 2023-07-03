package com.example.myinstaclone.presentation.screens._home.items

import com.example.myinstaclone.presentation.screens._home.listener.ItemClickListener
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.models.user_post.PostUi

data class PostItemAdapterModel(
    val posts: PostUi ,
    val listener: ItemClickListener ,
) : Item {
    fun id() = posts.objectsId
}