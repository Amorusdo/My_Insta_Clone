package com.example.myinstaclone.presentation.models.user_registration

import com.example.myinstaclone.presentation.models.user_image.ImageUi

class UserRegistrationUi(
    val objectId: String ,
    val userFullName: String ,
    val userEmail: String ,
    val userGender: Boolean? ,
    val phoneNumber: String? ,
    val profileBio: String? ,
    val userFollower: Int? ,
    val userFollowing: Int? ,
    val userCountPosts: Int? ,
    val userAvatar: ImageUi ,
    val userPassword: String? ,
    val sessionToken: String ,
    val userSingInId: String ,
    val createUserAt: String ,
)