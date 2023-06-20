package com.example.data._network.mapper_cloud.user

import com.example.data._network.models.user_registration.UpDataResponseCloud
import com.example.data.models.user_registration.UpDataResponseData
import com.example.domain.domain.interfaces.Mapper

class MapUpDataResponseCloudToData : Mapper<UpDataResponseCloud , UpDataResponseData> {
    override fun map(from: UpDataResponseCloud) = from.run {
        UpDataResponseData(
            upDataUser = upDataUser
        )
    }
}