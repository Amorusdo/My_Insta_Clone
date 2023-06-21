package com.example.myinstaclone.presentation.mapper.post

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_post.PostUi

class MapPostUiToDomain(
    private val mapper: Mapper<ImageUi , ImageDomain> ,
) : Mapper<PostUi , PostDomain> {
    override fun map(from: PostUi) = from.run {
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