package com.example.data.mapper_data.user

import com.example.data._network.models.user_image.ImageCloud
import com.example.data.models.user_image.ImageData
import com.example.domain.domain.interfaces.Mapper

class MapImageDataToCloud : Mapper<ImageData , ImageCloud> {
    override fun map(from: ImageData) = from.run {
        ImageCloud(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}