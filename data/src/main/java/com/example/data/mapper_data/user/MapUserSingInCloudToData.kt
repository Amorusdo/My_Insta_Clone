package com.example.data.mapper_data.user

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper

class MapUserSingInCloudToData(
    private val mapper: Mapper<ImageCloud , ImageData> ,
) : Mapper<UserSignInCloud , UserSignInData> {
    override fun map(from: UserSignInCloud): UserSignInData = from.run {
        UserSignInData(
            id = id ,
            userFullName = userFullName ,
            userEmail = userEmail ,
            userAge = userAge ,
            userGender = userGender ,
            phoneNumber = phoneNumber ,
            userBio = userBio ,
            userFollower = userFollower ,
            userFollowing = userFollowing ,
            userCountPosts = userCountPosts ,
            userAvatar = mapper.map(userAvatar) ,
            userId = userId
        )
    }
}