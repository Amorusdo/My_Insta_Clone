package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi

class MapUserRegistrationUiToDomain(
    private val mapper: Mapper<ImageUi , ImageDomain>
) : Mapper<UserRegistrationUi , UserRegistrationDomain> {
    override fun map(from: UserRegistrationUi) = from.run {
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