package com.example.data.mapper_data.comment

import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_comment.UserCommentsData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_comment.UserCommentsDomain

class MapGetResponseListCommentDataToDomain(
    private val mapper: Mapper<List<UserCommentsData> , List<UserCommentsDomain>>
) : Mapper<GetResponseListCommentsData , GetResponseListCommentsDomain> {
    override fun map(from: GetResponseListCommentsData) = from.run {
        GetResponseListCommentsDomain(
            comments = mapper.map(comments)
        )
    }
}