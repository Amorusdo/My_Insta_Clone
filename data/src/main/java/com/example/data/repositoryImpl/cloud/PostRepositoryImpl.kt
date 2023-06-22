package com.example.data.repositoryImpl.cloud

import com.example.data._network.sourse.post.PostCloudDataSours
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.ResponseData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.ResponseDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PostRepositoryImpl(
    private val postCloudDataSource: PostCloudDataSours ,
    private val mapPostDomainToData: Mapper<PostDomain , PostData> ,
    private val mapCreatePostResponseDataToDomain: Mapper<ResponseData , ResponseDomain> ,
    private val mapUserToData: Mapper<UserRegistrationDomain , UserRegistrationData> ,
    private val mapUserSignUpToData: Mapper<UserSignInDomain , UserSignInData> ,
    private val mapUserResponse: Mapper<ResponseData , ResponseDomain> ,
    private val mapUserSignUpDataTo: Mapper<ResponseData , ResponseDomain> ,
    private val mapComment: Mapper<UserCommentsDomain , UserCommentsData> ,
    private val mapCommentResponse: Mapper<ResponseData , ResponseDomain> ,
) : PostRepository {

    override fun createPost(post: PostDomain): Flow<ResponseDomain> =
        postCloudDataSource.createPost(mapPostDomainToData.map(post))
            .map(mapCreatePostResponseDataToDomain::map)
            .flowOn(Dispatchers.Default)

    //////////////////////////////////////////////////////
    override suspend fun deletePost(deletePostId: String) {
    }

    /////////////////////////////////////////////
    override fun userSignUp(user: UserRegistrationDomain): Flow<ResponseDomain> =
        postCloudDataSource.userSignUp(user = mapUserToData.map(user))
            .map(mapUserResponse::map)
            .flowOn(Dispatchers.Default)

    override fun singIn(user: UserSignInDomain): Flow<ResponseDomain> =
        postCloudDataSource.singIn(user = mapUserSignUpToData.map(user))
            .map(mapUserSignUpDataTo::map)
            .flowOn(Dispatchers.Default)
    ////////////////////////////////////////

    override fun postComments(comment: UserCommentsDomain): Flow<ResponseDomain> =
        postCloudDataSource.postComments(mapComment.map(comment))
            .flowOn(Dispatchers.IO)
            .map(mapCommentResponse::map)
            .flowOn(Dispatchers.Default)

}
