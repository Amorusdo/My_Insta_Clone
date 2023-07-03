package com.example.myinstaclone.presentation.all.adapter.postsImages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.all.adapter.diffCallBack.DiffCallBackPostUi
import com.example.myinstaclone.presentation.models.user_post.PostUi


class PostImagesAdaptor(

    private val listener: OnItemClickListenerImageProfile ,
    private val countPost : CountPost ,

    ) : RecyclerView.Adapter<PostImageViewHolder>() {

       var postsImages: List<PostUi> = emptyList()
        set(value) {
            val callback = DiffCallBackPostUi(postsImages , value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PostImageViewHolder =
        PostImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_my_images , parent , false)
        )


    override fun onBindViewHolder(holder: PostImageViewHolder , position: Int) {
        holder.bind(postsImages[position])
        holder.postImage.setOnClickListener {
            listener.onItemClick(position, id = holder.id)
        }


    }

    override fun getItemCount(): Int = postsImages.size


    interface OnItemClickListenerImageProfile {
        fun onItemClick(position: Int , id: String)

    }
    interface CountPost{
        fun countPost(position: Int, count:Int)
    }
}


