package com.example.data.mapper_data.post

import com.example.data._network.models.user_post.PostCloud
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper

class MapListDataPostToListCloud(
    private val mapper: Mapper<PostData , PostCloud>
) : Mapper<List<PostData> , List<PostCloud>> {
    override fun map(from: List<PostData>) = from.run {
        map(mapper::map)
    }
}