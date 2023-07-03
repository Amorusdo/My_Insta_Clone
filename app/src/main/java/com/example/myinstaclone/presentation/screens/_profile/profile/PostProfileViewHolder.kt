package com.example.myinstaclone.presentation.screens._profile.profile

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.squareup.picasso.Picasso

class PostProfileViewHolder(
    val view: View,
) : RecyclerView.ViewHolder(view) {
    private val avatar: ImageView = view.findViewById(R.id.foto_search)

    fun bind(user: PostUi) {
        Picasso.get().load(user.postImage?.imageUrl).into(avatar)

    }
}

