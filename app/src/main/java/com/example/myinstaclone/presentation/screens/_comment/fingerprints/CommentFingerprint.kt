package com.example.myinstaclone.presentation.screens._comment.fingerprints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.ItemCommentsBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint
import com.example.myinstaclone.presentation.screens._comment.items.CommentItemAdapterModel

class CommentFingerprint : ItemFingerprint<ItemCommentsBinding , CommentItemAdapterModel> {

    override fun isRelativeItem(item: Item) = item is CommentItemAdapterModel

    override fun getLayoutId() = R.layout.item_comments

    override fun getViewHolder(
        layoutInflater: LayoutInflater ,
        parent: ViewGroup ,
    ): BaseViewHolder<ItemCommentsBinding , CommentItemAdapterModel> {
        val binding = ItemCommentsBinding.inflate(layoutInflater , parent , false)
        return CollectionViewHolderComments(binding)
    }

    override fun getDiffUtil() = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<CommentItemAdapterModel>() {

        override fun areItemsTheSame(
            oldItem: CommentItemAdapterModel ,
            newItem: CommentItemAdapterModel ,
        ) = oldItem.comments.idPostForComments == newItem.comments.idPostForComments

        override fun areContentsTheSame(
            oldItem: CommentItemAdapterModel ,
            newItem: CommentItemAdapterModel ,
        ) = oldItem == newItem
    }
}

class CollectionViewHolderComments(
    binding: ItemCommentsBinding ,
) : BaseViewHolder<ItemCommentsBinding , CommentItemAdapterModel>(binding) {

    override fun onBind(item: CommentItemAdapterModel) = with(binding) {
        super.onBind(item)
        setupViews()
        setOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        Glide
            .with(itemView.context)
            .load(item.comments.commentImageUser?.imageUrl)
            .into(commentsFotos)

        commentsUserName.text = item.comments.userName
        commentsUser.text =item.comments.userComments
        commentsData.text = item.comments.data
    }

    private fun setOnClickListeners() = with(binding) {
        commentsAnswer.setOnClickListener {
            item.listener.onAnswerItemClick(item.comments.idPostForComments)
        }
    }

}