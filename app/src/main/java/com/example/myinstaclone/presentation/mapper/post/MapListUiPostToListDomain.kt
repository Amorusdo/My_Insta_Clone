package com.example.myinstaclone.presentation.mapper.post

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain
import com.example.myinstaclone.presentation.models.user_post.PostUi

class MapListUiPostToListDomain(
    private val mapper: Mapper<PostUi , PostDomain>
) : Mapper<List<PostUi> , List<PostDomain>> {
    override fun map(from: List<PostUi>) = from.run {
        map(mapper::map)
    }
}