package com.example.myinstaclone.presentation.mapper.comment

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi

class MapListUserCommentDomainToUi(
    private val mapper: Mapper<UserCommentsDomain , UserCommentsUi>
) :
    Mapper<List<UserCommentsDomain> , List<UserCommentsUi>> {
    override fun map(from: List<UserCommentsDomain>) = from.run {
        map(mapper::map)
    }
}