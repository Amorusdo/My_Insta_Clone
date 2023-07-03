package com.example.myinstaclone.presentation.all.adapter.postsImages

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.squareup.picasso.Picasso

class PostImageViewHolder(
    val view: View
) : RecyclerView.ViewHolder(view) {
    val postImage: ImageView = view.findViewById(R.id.ivAvengers)
    var id =""

    fun bind(user: PostUi) {
        id = user.objectsId.toString()
        Picasso.get().load(user.postImage?.imageUrl).into(postImage)
    }
}



