package com.example.myinstaclone.presentation.all.adapter.addFriends

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import com.squareup.picasso.Picasso

class AddFriendsViewHolder(
    val view: View ,
) : RecyclerView.ViewHolder(view) {
    private var friendsPhoto: ImageView = view.findViewById(R.id.friendsFotos)
    private var name = view.findViewById<TextView>(R.id.userName)

    fun bind(user: UserSignInUi) {
        Picasso.get().load(user.userAvatar.imageUrl).into(friendsPhoto)
       name.text = user.userFullName
    }
}