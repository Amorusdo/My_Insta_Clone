package com.example.myinstaclone.presentation.all.adapter.diffCallBack

import androidx.recyclerview.widget.DiffUtil
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi


class DiffCallBackUserCommentsUi(
    private val oldList: List<UserCommentsUi> ,
    private val newList: List<UserCommentsUi>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean {
        val oldUser =oldList[oldItemPosition]
        val newUser= newList[newItemPosition]
        return oldUser.userComments==newUser.userComments
    }

    override fun areContentsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser==newUser
    }
}