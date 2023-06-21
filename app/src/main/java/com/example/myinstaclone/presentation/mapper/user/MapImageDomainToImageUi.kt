package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.myinstaclone.presentation.models.user_image.ImageUi

class MapImageDomainToImageUi : Mapper<ImageDomain , ImageUi> {
    override fun map(from: ImageDomain) = from.run {
        ImageUi(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}