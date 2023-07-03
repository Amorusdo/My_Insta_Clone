package com.example.myinstaclone.presentation.all.adapter.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.all.adapter.diffCallBack.DiffCallBackUserCommentsUi
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi


class CommentAdaptor: RecyclerView.Adapter<CommentViewHolder>() {

    var comment: List<UserCommentsUi> = emptyList()
        set(newValue) {
            val callback = DiffCallBackUserCommentsUi( comment, newValue)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = newValue
        }


    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_comments, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder , position: Int) {
        holder.bindComment(comment[position])
    }

    override fun getItemCount(): Int =  comment.size





}



