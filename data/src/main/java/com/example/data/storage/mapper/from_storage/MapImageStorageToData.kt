package com.example.data.storage.mapper.from_storage

import com.example.data.models.user_image.ImageData
import com.example.data.storage.model.ImageUserStorage
import com.example.domain.domain.interfaces.Mapper

class MapImageStorageToData : Mapper<ImageUserStorage , ImageData> {
    override fun map(from: ImageUserStorage): ImageData = from.run {
        ImageData(
            type = type ,
            imageName = imageName ,
            imageUrl = imageUrl ,
        )
    }
}