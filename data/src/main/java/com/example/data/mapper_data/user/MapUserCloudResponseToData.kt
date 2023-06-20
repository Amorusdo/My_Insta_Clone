package com.example.data.mapper_data.user

import com.example.data._network.models.user_registration.ResponseCloud
import com.example.data.models.user_registration.ResponseData
import com.example.domain.domain.interfaces.Mapper

class MapUserCloudResponseToData : Mapper<ResponseCloud , ResponseData> {
    override fun map(from: ResponseCloud) = from.run {
        ResponseData(
            userId = userId ,
            sessionToken = sessionToken ,
            date = date
        )
    }
}