package com.example.data.mapper_data.comment

import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain

class MapListUserCommentDomainToData(
    private val mapper: Mapper<UserCommentsDomain , UserCommentsData>
) :
    Mapper<List<UserCommentsDomain> , List<UserCommentsData>> {
    override fun map(from: List<UserCommentsDomain>) = from.run {
        map(mapper::map)
    }
}