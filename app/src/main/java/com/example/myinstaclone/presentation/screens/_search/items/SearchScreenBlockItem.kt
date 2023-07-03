package com.example.myinstaclone.presentation.screens._search.items

import android.os.Parcelable
import com.example.myinstaclone.presentation.adaptor.Item


data class SearchScreenBlockItem(
    val items: List<Item> ,
    var state: Parcelable? = null
) : Item
