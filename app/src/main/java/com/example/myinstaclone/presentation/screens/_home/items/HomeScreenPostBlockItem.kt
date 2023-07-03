package com.example.myinstaclone.presentation.screens._home.items

import android.os.Parcelable
import com.example.myinstaclone.presentation.adaptor.Item

data class HomeScreenPostBlockItem(
    val items: List<Item> ,
    var state: Parcelable? = null

) : Item

data class UserBlockItem(
    val items: List<Item> ,
    var state: Parcelable? = null

) : Item