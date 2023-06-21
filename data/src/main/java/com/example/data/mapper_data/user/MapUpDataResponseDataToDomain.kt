package com.example.data.mapper_data.user

import com.example.data.models.user_registration.UpDataResponseData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UpDataResponseDomain

class MapUpDataResponseDataToDomain : Mapper<UpDataResponseData , UpDataResponseDomain> {
    override fun map(from: UpDataResponseData) = from.run {
        UpDataResponseDomain(
            upDataUser = upDataUser
        )
    }
}