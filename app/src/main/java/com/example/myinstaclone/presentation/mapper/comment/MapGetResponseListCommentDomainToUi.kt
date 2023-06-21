package com.example.myinstaclone.presentation.mapper.comment

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.myinstaclone.presentation.models.user_comment.GetResponseListCommentsUi
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi

class MapGetResponseListCommentDomainToUi(
    private val mapper: Mapper<List<UserCommentsDomain> , List<UserCommentsUi>>
) : Mapper<GetResponseListCommentsDomain , GetResponseListCommentsUi> {
    override fun map(from: GetResponseListCommentsDomain) = from.run {
        GetResponseListCommentsUi(
            comments = mapper.map(comments)
        )
    }
}