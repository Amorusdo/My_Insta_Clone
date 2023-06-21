package com.example.myinstaclone.presentation.models.user_comment

import com.example.myinstaclone.presentation.models.user_image.ImageUi

class UserCommentsUi(
    val userName: String ,
    val userComments: String ,
    val idPostForComments: String ,
    val commentImageUser: ImageUi? ,
    val data: String
)