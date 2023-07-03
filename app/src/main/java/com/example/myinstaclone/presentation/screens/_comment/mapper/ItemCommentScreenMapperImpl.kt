package com.example.myinstaclone.presentation.screens._comment.mapper

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.screens._comment.items.CommentItemAdapterModel
import com.example.myinstaclone.presentation.screens._comment.items.CommentScreenPostBlockItem
import com.example.myinstaclone.presentation.screens._comment.mapper.listener.ItemClickListenerComment
import javax.inject.Inject

class ItemCommentScreenMapperImpl @Inject constructor(
    private val postDomainToPostUiMapper: Mapper<UserCommentsDomain , UserCommentsUi> ,
) : ItemFilteredCommentMapper {

    override fun map(
        items: GetResponseListCommentsDomain ,
        searchQuery: String ,
        commentItemClickListener: ItemClickListenerComment ,
    ): Triple<List<Item> , List<Item> , List<Item>> {

        val filteredPostsList = items.comments.map(postDomainToPostUiMapper::map)
            .map {
                CommentItemAdapterModel(
                    comments = UserCommentsUi(
                        userName = it.userName ,
                        userComments = it.userComments ,
                        idPostForComments = it.idPostForComments ,
                        commentImageUser = ImageUi(
                            type = it.commentImageUser !!.type ,
                            imageUrl = it.commentImageUser.imageUrl
                        ) ,
                        data = it.data ,
                    ) ,
                    listener = commentItemClickListener ,
                )
            }


        val allItems = mutableListOf<Item>()

        val commentItemForPager = CommentScreenPostBlockItem(filteredPostsList)
        if (commentItemForPager.items.isNotEmpty()) allItems.addAll(
            listOf(commentItemForPager)
        )

        return Triple(allItems , emptyList() , emptyList())
    }
}


