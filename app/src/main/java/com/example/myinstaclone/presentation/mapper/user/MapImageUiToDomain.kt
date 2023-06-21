package com.example.myinstaclone.presentation.mapper.user

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.myinstaclone.presentation.models.user_image.ImageUi

class MapImageUiToDomain : Mapper<ImageUi , ImageDomain> {
    override fun map(from: ImageUi) = from.run {
        ImageDomain(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}