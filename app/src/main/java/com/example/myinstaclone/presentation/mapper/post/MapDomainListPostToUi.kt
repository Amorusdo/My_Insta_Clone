package com.example.myinstaclone.presentation.mapper.post

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain
import com.example.myinstaclone.presentation.models.user_post.PostUi

class MapDomainListPostToUi(
    private val mapper: Mapper<PostDomain , PostUi>
) : Mapper<List<PostDomain> , List<PostUi>> {
    override fun map(from: List<PostDomain>) = from.run {
        map(mapper::map)
    }
}