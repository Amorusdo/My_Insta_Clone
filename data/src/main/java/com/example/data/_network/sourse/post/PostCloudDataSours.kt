package com.example.data._network.sourse.post

import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.ResponseData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import kotlinx.coroutines.flow.Flow

interface PostCloudDataSours {

    fun userSignUp(user: UserRegistrationData): Flow<ResponseData>
    fun singIn(user: UserSignInData): Flow<ResponseData>
    fun createPost(post: PostData): Flow<ResponseData>
    suspend fun deletePost(deletePostId: String)
    fun postComments(comment: UserCommentsData): Flow<ResponseData>

}