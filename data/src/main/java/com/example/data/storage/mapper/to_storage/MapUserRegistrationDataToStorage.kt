package com.example.data.storage.mapper.to_storage

import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.storage.model.ImageUserStorage
import com.example.data.storage.model.UserRegistrationStorage
import com.example.domain.domain.interfaces.Mapper

class MapUserRegistrationDataToStorage(
    private val mapper: Mapper<ImageData , ImageUserStorage>
) : Mapper<UserRegistrationData , UserRegistrationStorage> {
    override fun map(from: UserRegistrationData): UserRegistrationStorage = from.run {
        UserRegistrationStorage(
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