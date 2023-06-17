package com.example.data.models.user_registration

import com.example.data.models.user_image.ImageData

class UserSignInData(
    val id: String ,
    val userFullName: String ,
    val userEmail: String ,
    val userAge: String? ,
    val userGender: Boolean? ,
    val phoneNumber: String? ,
    val userBio: String? ,
    val userFollower: Int? ,
    val userFollowing: Int? ,
    val userCountPosts: Int? ,
    val userAvatar: ImageData ,
    val userId: String?
)