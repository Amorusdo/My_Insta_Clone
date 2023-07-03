package com.example.myinstaclone.presentation.all.adapter.deleteImages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.all.adapter.diffCallBack.DiffCallBackPostUi
import com.example.myinstaclone.presentation.models.user_post.PostUi


class DeleteImagesAdaptor : RecyclerView.Adapter<DeleteImageViewHolder>() {

    var postsImages: List<PostUi> = emptyList()
        set(value) {
            val callback = DiffCallBackPostUi(postsImages , value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): DeleteImageViewHolder =
        DeleteImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_delete_post, parent , false)
        )


    override fun onBindViewHolder(holder: DeleteImageViewHolder , position: Int) {
        holder.bind(postsImages[position])

    }
        override fun getItemCount(): Int = postsImages.size
}


