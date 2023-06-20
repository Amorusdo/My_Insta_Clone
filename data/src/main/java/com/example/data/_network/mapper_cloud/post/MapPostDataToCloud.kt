package com.example.data._network.mapper_cloud.post

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_post.PostData
import com.example.domain.domain.interfaces.Mapper

class MapPostDataToCloud(
    private val mapper: Mapper<ImageData , ImageCloud> ,
) : Mapper<PostData , PostCloud> {
    override fun map(from: PostData) = from.run {
        PostCloud(
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