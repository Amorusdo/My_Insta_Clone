package com.example.data.mapper_data.user

import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UserSignInDomain

class MapListGetOneRegisteredUserDataToDomain(
    private val mapper: Mapper<UserSignInData , UserSignInDomain>
) : Mapper<List<UserSignInData> , List<UserSignInDomain>> {
    override fun map(from: List<UserSignInData>) = from.run {
        map(mapper::map)
    }
}