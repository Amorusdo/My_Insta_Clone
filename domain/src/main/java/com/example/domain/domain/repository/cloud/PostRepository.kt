package com.example.domain.domain.repository.cloud

import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.ResponseDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun createPost(post: PostDomain): Flow<ResponseDomain>

    suspend fun deletePost(deletePostId: String)

    fun userSignUp(user: UserRegistrationDomain): Flow<ResponseDomain>

    fun singIn(user: UserSignInDomain): Flow<ResponseDomain>

    fun postComments(comment: UserCommentsDomain): Flow<ResponseDomain>

}