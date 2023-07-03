package com.example.myinstaclone.presentation.all.adapter.diffCallBack

import androidx.recyclerview.widget.DiffUtil
import com.example.myinstaclone.presentation.models.user_post.PostUi


class DiffCallBackPostUi(
    private val oldList: List<PostUi> ,
    private val newList: List<PostUi>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean {
        val oldUser =oldList[oldItemPosition]
        val newUser= newList[newItemPosition]
        return oldUser.objectsId==newUser.objectsId
    }

    override fun areContentsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser==newUser
    }
}