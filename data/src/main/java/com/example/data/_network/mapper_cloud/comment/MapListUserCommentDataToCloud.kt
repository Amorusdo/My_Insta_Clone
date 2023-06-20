package com.example.data._network.mapper_cloud.comment

import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper

class MapListUserCommentDataToCloud(
    private val mapper: Mapper<UserCommentsData , UserCommentsCloud>
) :
    Mapper<List<UserCommentsData> , List<UserCommentsCloud>> {
    override fun map(from: List<UserCommentsData>) = from.run {
        map(mapper::map)
    }
}