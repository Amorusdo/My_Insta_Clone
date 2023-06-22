package com.example.domain.domain.use_case.home

import com.example.domain.domain.models.user_registration.HomeScreenItemDomain
import com.example.domain.domain.repository.cloud.GetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn

class FetchAllHomeScreenItemsUseCaseImpl(
    postRepository: GetRepository ,
) : FetchAllHomeScreenItemsUseCase {

    override fun invoke(): Flow<HomeScreenItemDomain> =
        combine(
            postsFlow ,
            userFlow
        ) { post , user ->
            HomeScreenItemDomain(
                posts = post ,
                users = user
            )
        }


    private val postsFlow = postRepository.getAllPost().flowOn(Dispatchers.IO)

    private val userFlow = postRepository.registeredUserAll().flowOn(Dispatchers.IO)

}