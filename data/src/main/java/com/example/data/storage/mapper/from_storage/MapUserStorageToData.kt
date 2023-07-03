package com.example.data.storage.mapper.from_storage

import com.example.data.models.user_image.ImageData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.storage.model.ImageUserStorage
import com.example.data.storage.model.UserRegistrationStorage
import com.example.domain.domain.interfaces.Mapper

class MapUserStorageToData(
    private val mapper: Mapper<ImageUserStorage , ImageData>
) : Mapper<UserRegistrationStorage , UserRegistrationData> {
    override fun map(from: UserRegistrationStorage): UserRegistrationData = from.run {
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