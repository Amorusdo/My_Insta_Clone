package com.example.myinstaclone.presentation.all.adapter.allFriends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.all.adapter.diffCallBack.DiffCallBackUserSingnInUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi

class AllFriendsAdaptor : RecyclerView.Adapter<AllFriendsViewHolder>() {
    var signUser: List<UserSignInUi> = emptyList()
        set(value) {
            val callback = DiffCallBackUserSingnInUi(field , value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): AllFriendsViewHolder {
        return AllFriendsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_users, parent , false)
        )
    }

    override fun getItemCount(): Int {
        return signUser.count()
    }

    override fun onBindViewHolder(holder: AllFriendsViewHolder , position: Int) {
        holder.bind(signUser[position])
    }
}


