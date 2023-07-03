package com.example.data.storage.model

import java.util.*

class UserRegistrationStorage(
    val objectId: String ,
    val userFullName: String ,
    val userEmail: String ,
    val userGender: Boolean? ,
    val phoneNumber: String? ,
    val profileBio: String? ,
    val userFollower: Int? ,
    val userFollowing: Int? ,
    val userCountPosts: Int? ,
    val userAvatar: ImageUserStorage ,
    val userPassword: String? ,
    val sessionToken: String ,
    val userSingInId: String ,
    val createUserAt: String ,
) {
    companion object {
        fun unkown() = UserRegistrationStorage(
            objectId = UUID.randomUUID().toString() ,
            userFullName = String() ,
            userEmail = String() ,
            userGender = null ,
            phoneNumber = String() ,
            profileBio = String() ,
            userFollower = null ,
            userFollowing = null ,
            userCountPosts = null ,
            userAvatar = ImageUserStorage.unkown() ,
            userPassword = String() ,
            sessionToken = String() ,
            userSingInId = String() ,
            createUserAt = String() ,
        )
    }
}
