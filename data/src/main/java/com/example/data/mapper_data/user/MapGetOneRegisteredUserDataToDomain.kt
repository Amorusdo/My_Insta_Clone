package com.example.data.mapper_data.user

import com.example.data.models.user_registration.UserGetOneRegisteredData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UserGetOneRegisteredDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain

class MapGetOneRegisteredUserDataToDomain(
    private val mapper: Mapper<List<UserSignInData> , List<UserSignInDomain>>
) :
    Mapper<UserGetOneRegisteredData , UserGetOneRegisteredDomain> {
    override fun map(from: UserGetOneRegisteredData) = from.run {
        UserGetOneRegisteredDomain(
            userList = mapper.map(userList)
        )
    }
}