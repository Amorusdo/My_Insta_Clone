package com.example.data.mapper_data.user

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.domain.domain.interfaces.Mapper

class MapUserRegistrationCloudToData(private val mapper: Mapper<ImageCloud , ImageData>) :
    Mapper<UserRegistrationCloud , UserRegistrationData> {
    override fun map(from: UserRegistrationCloud): UserRegistrationData = from.run {
        UserRegistrationData(
            objectId = objectId ,
            userFullName = userFullName ,
            userEmail = userEmail ,
            userGender = userGender ,
            phoneNumber = phoneNumber ,
            profileBio = profileBio ,
            userFollower = userFollower ,
            userFollowing = userFollowing ,
            userCountPosts = userCountPosts ,
            userAvatar = mapper.map(userAvatar) ,
            userPassword = userPassword ,
            sessionToken = sessionToken ,
            userSingInId = userSingInId ,
            createUserAt = createUserAt
        )
    }
}