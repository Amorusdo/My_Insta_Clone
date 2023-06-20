package com.example.data.mapper_data.user

import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper

class MapListGetOneRegisteredUserCloudToData(
    private val mapper: Mapper<UserSignInCloud , UserSignInData>
) : Mapper<List<UserSignInCloud> , List<UserSignInData>> {
    override fun map(from: List<UserSignInCloud>) = from.run {
        map(mapper::map)
    }
}