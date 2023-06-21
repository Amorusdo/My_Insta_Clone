package com.example.data.mapper_data.user

import com.example.data.models.user_registration.ResponseData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.ResponseDomain

class MapUserDataResponseToDomain : Mapper<ResponseData , ResponseDomain> {
    override fun map(from: ResponseData) = from.run {
        ResponseDomain(
            userId = userId ,
            sessionToken = sessionToken ,
            date = date
        )
    }
}