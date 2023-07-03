package com.example.myinstaclone.presentation.all.adapter.diffCallBack

import androidx.recyclerview.widget.DiffUtil
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi


class DiffCallBackUserSingnInUi(
    private val oldList: List<UserSignInUi> ,
    private val newList: List<UserSignInUi>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int , newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}