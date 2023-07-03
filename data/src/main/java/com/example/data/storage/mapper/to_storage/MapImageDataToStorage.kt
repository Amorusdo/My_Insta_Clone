package com.example.data.storage.mapper.to_storage

import com.example.data.models.user_image.ImageData
import com.example.data.storage.model.ImageUserStorage
import com.example.domain.domain.interfaces.Mapper

class MapImageDataToStorage : Mapper<ImageData , ImageUserStorage> {
    override fun map(from: ImageData): ImageUserStorage = from.run {
        ImageUserStorage(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}