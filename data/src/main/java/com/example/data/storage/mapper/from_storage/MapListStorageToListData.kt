package com.example.data.storage.mapper.from_storage

import com.example.data.models.user_post.PostData
import com.example.data.storage.model.PostStorage
import com.example.domain.domain.interfaces.Mapper

class MapListStorageToListData(
    private val mapper: Mapper<PostData , PostStorage>
) : Mapper<List<PostData> , List<PostStorage>> {
    override fun map(from: List<PostData>): List<PostStorage> = from.run {
        map(mapper::map)
    }
}