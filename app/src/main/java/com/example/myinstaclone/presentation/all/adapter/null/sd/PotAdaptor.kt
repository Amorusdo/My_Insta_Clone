package com.example.myinstaclone.presentation.all.adapter.`null`.sd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi


class PotAdaptor(
) : RecyclerView.Adapter<PotViewHolder>() {

    var post: List<UserCommentsUi> = emptyList()
        set(newValue) {
            val callback = DiffCallBackPot(field , newValue)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }


    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PotViewHolder {
        return PotViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_layout , parent , false)
        )
    }

    override fun getItemCount(): Int {
        return post.count()
    }

    override fun onBindViewHolder(holder: PotViewHolder , position: Int) {
        holder.bindPost(post[position])

    }

}



