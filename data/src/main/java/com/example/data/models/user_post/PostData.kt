package com.example.data.models.user_post

import com.example.data.models.user_image.ImageData

class PostData(
    val objectsId: String? ,
    val postImage: ImageData? ,
    val description: String ,
    val postId: String ,
    val avatarName: ImageData? ,
    val userImagePost: String? ,
    val postHolderName: String? ,
    val likes: Int ,
)