package com.example.data.mapper_data.post

import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain

class MapListDomainPostToListData(
    private val mapper: Mapper<PostDomain , PostData>
) : Mapper<List<PostDomain> , List<PostData>> {
    override fun map(from: List<PostDomain>) = from.run {
        map(mapper::map)
    }
}