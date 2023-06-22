package com.example.data._network.sourse.post

import com.example.data._network.api.PostApi
import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.ResponseCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.ResponseData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PostCloudDataSoursImpl(
    private val api: PostApi ,
    private val mapUserDataToCloud: Mapper<UserRegistrationData , UserRegistrationCloud> ,
    private val mapUserSingUpCloudToData: Mapper<UserSignInData , UserSignInCloud> ,
    private val mapPostDataToCloud: Mapper<PostData , PostCloud> ,
    private val mapComment: Mapper<UserCommentsData , UserCommentsCloud> ,
    private val mapPostCommentResponse: Mapper<ResponseCloud , ResponseData> ,
) : PostCloudDataSours {

    override fun createPost(post: PostData): Flow<ResponseData> = flow {
        emit(api.createPost(mapPostDataToCloud.map(post)))
    }.flowOn(Dispatchers.IO)
        .map(mapPostCommentResponse::map)
        .flowOn(Dispatchers.Default)

    override fun userSignUp(user: UserRegistrationData): Flow<ResponseData> = flow {
        emit(api.userSignUp(user = mapUserDataToCloud.map(user)))
    }.flowOn(Dispatchers.IO)
        .map(mapPostCommentResponse::map)
        .flowOn(Dispatchers.Default)

    override fun singIn(user: UserSignInData): Flow<ResponseData> = flow {
        emit(api.singIn(user = mapUserSingUpCloudToData.map(user)))
    }.flowOn(Dispatchers.IO)
        .map(mapPostCommentResponse::map)
        .flowOn(Dispatchers.Default)

    override suspend fun deletePost(deletePostId: String) {

    }

    override fun postComments(comment: UserCommentsData): Flow<ResponseData> = flow {
        emit(api.postComments(mapComment.map(comment)))
    }.flowOn(Dispatchers.IO)
        .map(mapPostCommentResponse::map)
        .flowOn(Dispatchers.Default)
}