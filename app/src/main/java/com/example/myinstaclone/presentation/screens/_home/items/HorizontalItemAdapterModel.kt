package com.example.myinstaclone.presentation.screens._home.items

import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.lisener.UsersItemClickListener
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi

data class HorizontalItemAdapterModel(
    val users: UserSignInUi ,
    val listener: UsersItemClickListener ,
) : Item {
    fun id() = users.id
}