package com.example.data._network.mapper_cloud.comment

import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data._network.models.user_image.ImageCloud
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_image.ImageData
import com.example.domain.domain.interfaces.Mapper

class MapUserCommentCloudToData(
    private val mapper: Mapper<ImageCloud , ImageData>
) :
    Mapper<UserCommentsCloud , UserCommentsData> {
    override fun map(from: UserCommentsCloud) = from.run {
        UserCommentsData(
            userName = userName ,
            userComments = userComments ,
            idPostForComments = idPostForComments ,
            commentImageUser = commentImageUser?.let { mapper.map(it) } ,
            data = data
        )
    }
}