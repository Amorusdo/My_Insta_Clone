package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UserGetOneRegisteredDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.myinstaclone.presentation.models.user_registration.UserGetOneRegisteredUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi

class MapGetOneRegisteredUserDomainToUi(
    private val mapper: Mapper<List<UserSignInDomain> , List<UserSignInUi>>
) :
    Mapper<UserGetOneRegisteredDomain , UserGetOneRegisteredUi> {
    override fun map(from: UserGetOneRegisteredDomain) = from.run {
        UserGetOneRegisteredUi(
            userList = mapper.map(userList)
        )
    }
}