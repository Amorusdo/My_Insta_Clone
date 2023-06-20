package com.example.data.mapper_data.comment

import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain

class MapListUserCommentDataToDomain(
    private val mapper: Mapper<UserCommentsData , UserCommentsDomain>
) :
    Mapper<List<UserCommentsData> , List<UserCommentsDomain>> {
    override fun map(from: List<UserCommentsData>) = from.run {
        map(mapper::map)
    }
}