package com.example.data.models.user_comment

import com.example.data.models.user_image.ImageData

class UserCommentsData(
    val userName: String ,
    val userComments: String ,
    val idPostForComments: String ,
    val commentImageUser: ImageData? ,
    val data: String
)