package com.example.data._network.mapper_cloud.post

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper

class MapPostCloudToData(
    private val mapper: Mapper<ImageCloud , ImageData> ,
) : Mapper<PostCloud , PostData> {
    override fun map(from: PostCloud) = from.run {
        PostData(
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