package com.example.myinstaclone.presentation.screens._search.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.all.adapter.diffCallBack.DiffCallBackPostUi
import com.example.myinstaclone.presentation.models.user_post.PostUi


class ProfileAdaptor() : RecyclerView.Adapter<PostProfileViewHolder>() {

        var postsProfile: List<PostUi> = emptyList()
        set(value) {
            val callback = DiffCallBackPostUi(postsProfile , value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PostProfileViewHolder =
        PostProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_all_photos_videos , parent , false)
        )

    override fun onBindViewHolder(holder: PostProfileViewHolder , position: Int) {
        holder.bind(postsProfile[position])
    }

    override fun getItemCount(): Int = postsProfile.size

}