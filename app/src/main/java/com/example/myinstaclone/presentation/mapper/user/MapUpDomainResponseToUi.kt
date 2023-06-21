package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.UpDataResponseDomain
import com.example.myinstaclone.presentation.models.user_registration.UpDataResponseUi

class MapUpDomainResponseToUi : Mapper<UpDataResponseDomain , UpDataResponseUi> {
    override fun map(from: UpDataResponseDomain) = from.run {
        UpDataResponseUi(
            upDataUser = upDataUser
        )
    }
}