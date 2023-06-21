package com.example.myinstaclone.presentation.models.user_registration

import com.example.domain.domain.interfaces.Item
import com.example.myinstaclone.presentation.models.user_image.ImageUi

class UserSignInUi(
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
    val userAvatar: ImageUi ,
    val userId: String?
) : Item