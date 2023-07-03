package com.example.myinstaclone.presentation.screens._home.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.ItemUsersBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint
import com.example.myinstaclone.presentation.screens._home.items.HorizontalItemAdapterModel

class UserFingerprint : ItemFingerprint<ItemUsersBinding , HorizontalItemAdapterModel> {

    override fun isRelativeItem(item: Item) = item is HorizontalItemAdapterModel

    override fun getLayoutId() = R.layout.item_users


    override fun getViewHolder(
        layoutInflater: LayoutInflater ,
        parent: ViewGroup ,
    ): BaseViewHolder<ItemUsersBinding , HorizontalItemAdapterModel> {
        val binding = ItemUsersBinding.inflate(layoutInflater , parent , false)
        return CollectionnViewHolder(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<HorizontalItemAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: HorizontalItemAdapterModel ,
            newItem: HorizontalItemAdapterModel ,
        ) = oldItem.users.id == newItem.users.id

        override fun areContentsTheSame(
            oldItem: HorizontalItemAdapterModel ,
            newItem: HorizontalItemAdapterModel ,
        ) = oldItem == newItem
    }

}

class CollectionnViewHolder(
    binding: ItemUsersBinding ,
) : BaseViewHolder<ItemUsersBinding , HorizontalItemAdapterModel>(binding) {

    override fun onBind(item: HorizontalItemAdapterModel) = with(binding) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {

        Glide
            .with(itemView.context)
            .load(item.users.userAvatar.imageUrl)
            .into(imageAllFriends)

        nameAllFriends.text = item.users.userFullName
    }

    private fun setOnClickListeners() = with(binding) {
        root.setOnClickListener {
            item.listener.onClick()
        }
//        goFragmentBtn.setOnDownEffectClickListener {}

    }

}