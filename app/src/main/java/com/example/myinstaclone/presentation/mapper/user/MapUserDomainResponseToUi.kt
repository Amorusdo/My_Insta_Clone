package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_registration.ResponseDomain
import com.example.myinstaclone.presentation.models.user_registration.ResponseUi

class MapUserDomainResponseToUi : Mapper<ResponseDomain , ResponseUi> {
    override fun map(from: ResponseDomain) = from.run {
        ResponseUi(
            userId = userId ,
            sessionToken = sessionToken ,
            date = date
        )
    }
}