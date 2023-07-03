package com.example.domain.domain.use_case.search

import com.example.domain.domain.models.search.SearchPostsItemDomain
import com.example.domain.domain.repository.cloud.GetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

    class FetchSearchScreenItemUseCaseImpl(
        private val allPost: GetRepository
    ) : FetchSearchScreenItemUseCase {
    override fun invoke(): Flow<SearchPostsItemDomain> =
        postFlow.map { post ->
            SearchPostsItemDomain(posts = post)
        }

    override fun invoke(accessToken: String) =
        allPost.getSearchByDescription(description = accessToken)


    private val postFlow = allPost.getAllPost().flowOn(Dispatchers.IO)
}