package com.example.domain.domain.models.user_registration

import com.example.domain.domain.interfaces.Item
import com.example.domain.domain.models.user_image.ImageDomain

class UserSignInDomain(
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
    val userAvatar: ImageDomain ,
    val userId: String?
) : Item