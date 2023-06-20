package com.example.data.mapper_data.comment

import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_image.ImageData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_image.ImageDomain

class MapUserCommentDataToDomain(
    private val mapper: Mapper<ImageData , ImageDomain>
) :
    Mapper<UserCommentsData , UserCommentsDomain> {
    override fun map(from: UserCommentsData) = from.run {
        UserCommentsDomain(
            userName = userName ,
            userComments = userComments ,
            idPostForComments = idPostForComments ,
            commentImageUser = commentImageUser?.let { mapper.map(it) } ,
            data = data
        )
    }
}