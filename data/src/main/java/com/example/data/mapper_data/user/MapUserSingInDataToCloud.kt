package com.example.data.mapper_data.user

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper

class MapUserSingInDataToCloud(
    private val mapper: Mapper<ImageData , ImageCloud>
) : Mapper<UserSignInData , UserSignInCloud> {
    override fun map(from: UserSignInData): UserSignInCloud = from.run {
        UserSignInCloud(
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