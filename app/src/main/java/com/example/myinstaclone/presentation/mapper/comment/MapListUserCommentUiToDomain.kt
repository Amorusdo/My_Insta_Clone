package com.example.myinstaclone.presentation.mapper.comment

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi

class MapListUserCommentUiToDomain(
    private val mapper: Mapper<UserCommentsUi , UserCommentsDomain>
) :
    Mapper<List<UserCommentsUi> , List<UserCommentsDomain>> {
    override fun map(from: List<UserCommentsUi>) = from.run {
        map(mapper::map)
    }
}