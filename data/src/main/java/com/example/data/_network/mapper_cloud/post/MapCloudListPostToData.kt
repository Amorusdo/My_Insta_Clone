package com.example.data._network.mapper_cloud.post

import com.example.data._network.models.user_post.PostCloud
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper

class MapCloudListPostToData(
    private val mapper: Mapper<PostCloud , PostData>
) : Mapper<List<PostCloud> , List<PostData>> {
    override fun map(from: List<PostCloud>) = from.run {
        map(mapper::map)
    }
}