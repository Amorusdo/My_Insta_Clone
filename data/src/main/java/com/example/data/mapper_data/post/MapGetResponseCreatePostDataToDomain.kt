package com.example.data.mapper_data.post

import com.example.data._network.models.search.GetResponseCreatePostCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data.models.search.GetResponseCreatePostData
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper

class MapGetResponseCreatePostDataToDomain(
    private val mapper: Mapper<List<PostCloud> , List<PostData>>
) :
    Mapper<GetResponseCreatePostCloud , GetResponseCreatePostData> {
    override fun map(from: GetResponseCreatePostCloud) = from.run {
        GetResponseCreatePostData(
            posts = mapper.map(posts)
        )
    }
}