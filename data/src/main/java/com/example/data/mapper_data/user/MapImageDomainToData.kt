package com.example.data.mapper_data.user

import com.example.data.models.user_image.ImageData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain

class MapImageDomainToData : Mapper<ImageDomain , ImageData> {
    override fun map(from: ImageDomain) = from.run {
        ImageData(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}