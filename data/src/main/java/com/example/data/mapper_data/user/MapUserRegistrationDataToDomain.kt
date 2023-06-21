package com.example.data.mapper_data.user

import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain

class MapUserRegistrationDataToDomain(private val mapper: Mapper<ImageData , ImageDomain>) :
    Mapper<UserRegistrationData , UserRegistrationDomain> {
    override fun map(from: UserRegistrationData) = from.run {
        UserRegistrationDomain(
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