package com.example.myinstaclone.presentation.all.adapter.`null`.sd

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi

import com.squareup.picasso.Picasso

class PotViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val avatar: ImageView = view.findViewById(R.id.postFotoProfile)
    val commentChat: ImageView = view.findViewById(R.id.postChatIcon)



    @SuppressLint("SetTextI18n")
    fun bindPost(posts: UserCommentsUi) {
        Picasso.get().load(posts.commentImageUser?.imageUrl).into(avatar)

    }


}



