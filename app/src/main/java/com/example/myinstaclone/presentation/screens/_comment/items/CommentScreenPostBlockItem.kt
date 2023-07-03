package com.example.myinstaclone.presentation.screens._comment.items

import android.os.Parcelable
import com.example.myinstaclone.presentation.adaptor.Item

data class CommentScreenPostBlockItem(
    val items: List<Item> ,
    var state: Parcelable? = null
) : Item
