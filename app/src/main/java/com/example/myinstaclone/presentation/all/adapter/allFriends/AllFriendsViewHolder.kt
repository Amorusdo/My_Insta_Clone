package com.example.myinstaclone.presentation.all.adapter.allFriends

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import com.squareup.picasso.Picasso

class AllFriendsViewHolder(
    val view: View ,
) : RecyclerView.ViewHolder(view) {
    private var friendsPhoto: ImageView = view.findViewById(R.id.image_all_friends)
    private var name = view.findViewById<TextView>(R.id.name_all_friends)

    fun bind(user: UserSignInUi) {
        Picasso.get().load(user.userAvatar.imageUrl).into(friendsPhoto)
        name.text = user.userFullName
    }
}