package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi

class MapUserSingInUiToDomain(
    private val mapper: Mapper<ImageUi , ImageDomain>
) : Mapper<UserSignInUi , UserSignInDomain> {
    override fun map(from: UserSignInUi) = from.run {
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