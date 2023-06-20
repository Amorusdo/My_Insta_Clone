package com.example.data.mapper_data.user

import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.a_network.models.user.GetOneRegisteredUserCloud
import com.example.data.models.user.GetOneRegisteredUserData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper

class MapGetOneRegisteredUserCloudToData(
    private val mapper: Mapper<List<UserSignInCloud> , List<UserSignInData>>
) :
    Mapper<GetOneRegisteredUserData , GetOneRegisteredUserDomain> {
    override fun map(from: GetOneRegisteredUserCloud): GetOneRegisteredUserData = from.run {
        GetOneRegisteredUserData(
            userList = mapper.map(userList)
        )
    }
}