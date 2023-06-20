package com.example.data._network.mapper_cloud.user

import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.domain.domain.interfaces.Mapper

class MapUserRegistrationDataToCloud(
    private val mapper: Mapper<ImageData , ImageCloud>
) : Mapper<UserRegistrationData , UserRegistrationCloud> {
    override fun map(from: UserRegistrationData): UserRegistrationCloud = from.run {
        UserRegistrationCloud(
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