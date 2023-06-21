package com.example.myinstaclone.presentation.mapper.comment

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_image.ImageUi

class MapUserCommentUiToDomain(
    private val mapper: Mapper<ImageUi , ImageDomain>
) :
    Mapper<UserCommentsUi , UserCommentsDomain> {
    override fun map(from: UserCommentsUi) = from.run {
        UserCommentsDomain(
            userName = userName ,
            userComments = userComments ,
            idPostForComments = idPostForComments ,
            commentImageUser = commentImageUser?.let { mapper.map(it) } ,
            data = data
        )
    }
}