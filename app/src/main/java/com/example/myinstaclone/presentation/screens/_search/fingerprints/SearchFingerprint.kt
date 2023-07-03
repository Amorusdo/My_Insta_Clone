package com.example.myinstaclone.presentation.screens._search.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.myinstaclone.presentation.screens._search.items.PostSearchItemAdapterModel
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.ItemAllPhotosVideosBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint

class SearchFingerprint: ItemFingerprint<ItemAllPhotosVideosBinding , PostSearchItemAdapterModel> {

    override fun isRelativeItem(item: Item) = item is PostSearchItemAdapterModel

    override fun getLayoutId() = R.layout.item_all_photos_videos


    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<ItemAllPhotosVideosBinding , PostSearchItemAdapterModel> {
        val binding = ItemAllPhotosVideosBinding.inflate(layoutInflater, parent, false)
        return CollectionViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<PostSearchItemAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: PostSearchItemAdapterModel ,
            newItem: PostSearchItemAdapterModel ,
        ) = oldItem.posts.postId == newItem.posts.postId

        override fun areContentsTheSame(
            oldItem: PostSearchItemAdapterModel ,
            newItem: PostSearchItemAdapterModel ,
        ) = oldItem == newItem
    }

}

class CollectionViewHolder(
    binding: ItemAllPhotosVideosBinding ,
) : BaseViewHolder<ItemAllPhotosVideosBinding , PostSearchItemAdapterModel>(binding) {

    override fun onBind(item: PostSearchItemAdapterModel)= with(binding) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        Glide
            .with(itemView.context)
            .load(item.posts.postImage?.imageUrl)
            .into(fotoSearch)

    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnClickListener { item.listener.onClick()
        }
//        goFragmentBtn.setOnDownEffectClickListener {}

    }

}