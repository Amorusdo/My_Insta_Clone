package com.example.myinstaclone.presentation.models.user_post

import com.example.myinstaclone.presentation.models.user_image.ImageUi

class PostUi(
    val objectsId: String? ,
    val postImage: ImageUi? ,
    val description: String ,
    val postId: String ,
    val avatarName: ImageUi? ,
    val userImagePost: String? ,
    val postHolderName: String? ,
    val likes: Int ,
)