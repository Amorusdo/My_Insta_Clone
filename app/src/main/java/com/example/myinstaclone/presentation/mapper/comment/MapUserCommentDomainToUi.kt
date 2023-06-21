package com.example.myinstaclone.presentation.mapper.comment

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_image.ImageUi

class MapUserCommentDomainToUi(
    private val mapper: Mapper<ImageDomain , ImageUi>
) :
    Mapper<UserCommentsDomain , UserCommentsUi> {
    override fun map(from: UserCommentsDomain) = from.run {
        UserCommentsUi(
            userName = userName ,
            userComments = userComments ,
            idPostForComments = idPostForComments ,
            commentImageUser = commentImageUser?.let { mapper.map(it) } ,
            data = data
        )
    }
}