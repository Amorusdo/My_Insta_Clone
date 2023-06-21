package com.example.data.mapper_data.post

import com.example.data.models.user_image.ImageData
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_post.PostDomain

class MapPostDataToDomain(
    private val mapper: Mapper<ImageData , ImageDomain> ,
) : Mapper<PostData , PostDomain> {
    override fun map(from: PostData) = from.run {
        PostDomain(
            objectsId = objectsId ,
            postImage = postImage?.let { mapper.map(it) } ,
            description = description ,
            postId = postId ,
            avatarName = avatarName?.let { mapper.map(it) } ,
            userImagePost = userImagePost ,
            postHolderName = postHolderName ,
            likes = likes ,
        )
    }
}