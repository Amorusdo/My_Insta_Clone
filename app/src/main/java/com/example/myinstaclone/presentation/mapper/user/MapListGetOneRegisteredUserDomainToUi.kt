package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi

class MapListGetOneRegisteredUserDomainToUi(
    private val mapper: Mapper<UserSignInDomain , UserSignInUi>
) : Mapper<List<UserSignInDomain> , List<UserSignInUi>> {
    override fun map(from: List<UserSignInDomain>) = from.run {
        map(mapper::map)
    }
}