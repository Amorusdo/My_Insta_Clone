package com.example.domain.domain.models.user_post

import com.example.domain.domain.models.user_image.ImageDomain

class PostDomain(
    val objectsId: String? ,
    val postImage: ImageDomain? ,
    val description: String ,
    val postId: String ,
    val avatarName: ImageDomain? ,
    val userImagePost: String? ,
    val postHolderName: String? ,
    val likes: Int ,
)