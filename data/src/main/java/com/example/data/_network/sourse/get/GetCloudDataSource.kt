package com.example.data._network.sourse.get

import com.example.data.models.search.GetResponseCreatePostData
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import kotlinx.coroutines.flow.Flow

interface GetCloudDataSource {

    fun registeredUserAll(): Flow<List<UserSignInData>>
    fun getSearchByDescription(description: String): Flow<List<PostData>>
    fun getAllPost(): Flow<List<PostData>>
    fun getPostsOneUser(postId: String): Flow<List<PostData>>


    suspend fun login(login: String , password: String): UserRegistrationData
    suspend fun userProfile(sessionToken: String): UserRegistrationData


    fun getOnePost(objectId: String): Flow<GetResponseCreatePostData>

    ////////////////////////////////////////////////
    fun getComments(idPost: String): Flow<GetResponseListCommentsData>
    fun getAllComments(): Flow<GetResponseListCommentsData>
}