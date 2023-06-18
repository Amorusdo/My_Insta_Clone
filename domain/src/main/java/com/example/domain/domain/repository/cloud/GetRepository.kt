package com.example.domain.domain.repository.cloud

import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import kotlinx.coroutines.flow.Flow


interface GetRepository {

    fun registeredUserAll(): Flow<List<UserSignInDomain>>
    fun getAllPost(): Flow<List<PostDomain>>
    fun getSearchByDescription(description: String): Flow<List<PostDomain>>
    fun getPostsOneUser(postId: String): Flow<List<PostDomain>>

    suspend fun logIn(login: String , password: String): UserRegistrationDomain
    suspend fun userProfile(sessionToken: String): UserRegistrationDomain

//  fun getOnePost(objectId: String): Flow<GetResponseCreatePostDomain>
    fun  getComments(idPost: String): Flow<GetResponseListCommentsDomain>
    fun getAllComments(): Flow<GetResponseListCommentsDomain>
}