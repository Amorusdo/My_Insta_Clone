package com.example.data._network.mapper_cloud.comment


import com.example.data._network.models.user_comment.GetResponseListCommentsCloud
import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper

class MapGetResponseListCommentCloudToData(
    private val mapper: Mapper<List<UserCommentsCloud> , List<UserCommentsData>>
) : Mapper<GetResponseListCommentsCloud , GetResponseListCommentsData> {
    override fun map(from: GetResponseListCommentsCloud) = from.run {
        GetResponseListCommentsData(
            comments = mapper.map(comments)
        )
    }
}