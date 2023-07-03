package com.example.myinstaclone.presentation.screens._home.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.myinstaclone.presentation.screens._home.items.PostItemAdapterModel
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.ItemHomeLayoutBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint

class PostFingerprint : ItemFingerprint<ItemHomeLayoutBinding , PostItemAdapterModel> {

    override fun isRelativeItem(item: Item) = item is PostItemAdapterModel

    override fun getLayoutId() = R.layout.item_home_layout

    override fun getViewHolder(
        layoutInflater: LayoutInflater ,
        parent: ViewGroup ,
    ): BaseViewHolder<ItemHomeLayoutBinding , PostItemAdapterModel> {
        val binding = ItemHomeLayoutBinding.inflate(layoutInflater , parent , false)
        return CollectionViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<PostItemAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: PostItemAdapterModel ,
            newItem: PostItemAdapterModel ,
        ) = oldItem.posts.description == newItem.posts.description

        override fun areContentsTheSame(
            oldItem: PostItemAdapterModel ,
            newItem: PostItemAdapterModel ,
        ) = oldItem == newItem
    }
}

class CollectionViewHolder(
    binding: ItemHomeLayoutBinding ,
) : BaseViewHolder<ItemHomeLayoutBinding , PostItemAdapterModel>(binding) {

    override fun onBind(item: PostItemAdapterModel) = with(binding) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        Glide
            .with(itemView.context)
            .load(item.posts.avatarName?.imageUrl)
            .into(postFotoProfile)
        Glide
            .with(itemView.context)
            .load(item.posts.avatarName?.imageUrl)
            .into(postImageComment)
        Glide
            .with(itemView.context)
            .load(item.posts.postImage?.imageUrl)
            .into(postImage)
        postNameProfileForComment.text = item.posts.postHolderName
        postNameUser.text = item.posts.postHolderName
        postDescriptionText.text = item.posts.description
    }

    private fun setOnClickListeners() = with(binding) {
        postChatIcon.setOnClickListener {
            item.listener.onShatItemClick(item.posts.postId)
        }
    }

}