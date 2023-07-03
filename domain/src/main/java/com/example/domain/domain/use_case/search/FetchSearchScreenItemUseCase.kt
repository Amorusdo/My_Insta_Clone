package com.example.domain.domain.use_case.search

import com.example.domain.domain.models.search.SearchPostsItemDomain
import com.example.domain.domain.models.user_post.PostDomain
import kotlinx.coroutines.flow.Flow

    interface FetchSearchScreenItemUseCase {

        operator fun invoke(): Flow<SearchPostsItemDomain>
        operator fun invoke(accessToken:String): Flow<List<PostDomain>>
    }


