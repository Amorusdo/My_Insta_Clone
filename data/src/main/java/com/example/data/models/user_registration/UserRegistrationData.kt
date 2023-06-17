package com.example.data.models.user_registration

import com.example.data.models.user_image.ImageData

class UserRegistrationData(
    val objectId: String ,
    val userFullName: String ,
    val userEmail: String ,
    val userGender: Boolean? ,
    val phoneNumber: String? ,
    val profileBio: String? ,
    val userFollower: Int? ,
    val userFollowing: Int? ,
    val userCountPosts: Int? ,
    val userAvatar: ImageData ,
    val userPassword: String? ,
    val sessionToken: String ,
    val userSingInId: String ,
    val createUserAt: String ,
)