package com.example.myinstaclone.presentation.all.adapter.comments

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.squareup.picasso.Picasso

class CommentViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val userNameComments = view.findViewById<TextView>(R.id.commentsUserName)
    private val commentComments = view.findViewById<TextView>(R.id.commentsUser)
    private val image: ImageView = view.findViewById(R.id.commentsFotos)
    private val date = view.findViewById<TextView>(R.id.commentsData)

    fun bindComment(comment: UserCommentsUi) {
        userNameComments.text = comment.userName
        commentComments.text = comment.userComments
        date.text = comment.data
        Picasso.get().load(comment.commentImageUser?.imageUrl).into(image)
    }
}