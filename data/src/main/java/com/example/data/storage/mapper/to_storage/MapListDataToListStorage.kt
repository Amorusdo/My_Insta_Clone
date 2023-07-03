package com.example.data.storage.mapper.to_storage

import com.example.data.models.user_post.PostData
import com.example.data.storage.model.PostStorage
import com.example.domain.domain.interfaces.Mapper

class MapListDataToListStorage(
    private val mapper: Mapper<PostStorage , PostData>
) : Mapper<List<PostStorage> , List<PostData>> {
    override fun map(from: List<PostStorage>): List<PostData> = from.run {
        map(mapper::map)
    }
}