package com.example.data._network.mapper_cloud.comment

import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper

class MapListUserCommentCloudToData(
    private val mapper: Mapper<UserCommentsCloud , UserCommentsData>
) :
    Mapper<List<UserCommentsCloud> , List<UserCommentsData>> {
    override fun map(from: List<UserCommentsCloud>) = from.run {
        map(mapper::map)
    }
}