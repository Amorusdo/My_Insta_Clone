package com.example.domain.domain.models.user_registration

import com.example.domain.domain.models.user_image.ImageDomain

class UserRegistrationDomain(
    val objectId: String ,
    val userFullName: String ,
    val userEmail: String ,
    val userGender: Boolean? ,
    val phoneNumber: String? ,
    val profileBio: String? ,
    val userFollower: Int? ,
    val userFollowing: Int? ,
    val userCountPosts: Int? ,
    val userAvatar: ImageDomain ,
    val userPassword: String? ,
    val sessionToken: String ,
    val userSingInId: String ,
    val createUserAt: String ,
)