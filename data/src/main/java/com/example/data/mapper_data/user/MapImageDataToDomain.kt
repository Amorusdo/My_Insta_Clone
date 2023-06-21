package com.example.data.mapper_data.user

import com.example.data.models.user_image.ImageData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_image.ImageDomain

class MapImageDataToDomain : Mapper<ImageData , ImageDomain> {
    override fun map(from: ImageData) = from.run {
        ImageDomain(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}