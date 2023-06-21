package com.example.data.mapper_data.user

import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain

class MapUserSingInDataToDomain(
    private val mapper: Mapper<ImageData , ImageDomain> ,
) : Mapper<UserSignInData , UserSignInDomain> {
    override fun map(from: UserSignInData) = from.run {
        UserSignInDomain(
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