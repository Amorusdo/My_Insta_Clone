package com.example.myinstaclone.presentation.all.adapter.deleteImages

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.squareup.picasso.Picasso

class DeleteImageViewHolder(
    val view: View,
) : RecyclerView.ViewHolder(view) {

   private val postIma: ImageView = view.findViewById(R.id.delete_image_post)

    fun bind(user: PostUi) {

        Picasso.get().load(user.postImage?.imageUrl).into(postIma)
    }
}



