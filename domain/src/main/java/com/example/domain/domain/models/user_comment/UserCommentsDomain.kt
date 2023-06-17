package com.example.domain.domain.models.user_comment

import com.example.domain.domain.models.user_image.ImageDomain

class UserCommentsDomain(
    val userName: String ,
    val userComments: String ,
    val idPostForComments: String ,
    val commentImageUser: ImageDomain? ,
    val data: String
)