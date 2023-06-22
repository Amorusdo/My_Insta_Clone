package com.example.data.repositoryImpl.cloud

import com.example.data._network.sourse.get.GetCloudDataSource
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.GetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRepositoryImpl @Inject constructor(
    private val getCloudDataSource: GetCloudDataSource ,
    private val mapDataUserToDomain: Mapper<UserRegistrationData , UserRegistrationDomain> ,
    private val mapGetOneRegisteredUser: Mapper<PostData , PostDomain> ,
    private val postDataToDomainMapper: Mapper<PostData , PostDomain> ,
    private val userSignInDomainMapper: Mapper<UserSignInData , UserSignInDomain> ,
    private val mapGetCommentResponse: Mapper<GetResponseListCommentsData , GetResponseListCommentsDomain> ,
) : GetRepository {


    override fun getAllPost(): Flow<List<PostDomain>> =
        getCloudDataSource.getAllPost()
            .map { post -> post.map(postDataToDomainMapper::map) }
            .flowOn(Dispatchers.Default)

    override fun registeredUserAll(): Flow<List<UserSignInDomain>> =
        getCloudDataSource.registeredUserAll()
            .map { user -> user.map(userSignInDomainMapper::map) }
            .flowOn(Dispatchers.Default)

    override fun getSearchByDescription(description: String): Flow<List<PostDomain>> =
        getCloudDataSource.getSearchByDescription(description = description)
            .map { post -> post.map(postDataToDomainMapper::map) }
            .flowOn(Dispatchers.Default)

    override fun getPostsOneUser(postId: String): Flow<List<PostDomain>> =
        getCloudDataSource.getPostsOneUser(postId = postId)
            .map { userPost -> userPost.map(mapGetOneRegisteredUser::map) }
            .flowOn(Dispatchers.Default)


    override suspend fun logIn(login: String , password: String): UserRegistrationDomain =
        mapDataUserToDomain.map(getCloudDataSource.login(login = login , password = password))

    override suspend fun userProfile(sessionToken: String): UserRegistrationDomain =
        mapDataUserToDomain.map(getCloudDataSource.userProfile(sessionToken = sessionToken))


//    override fun getOnePost(objectId: String): Flow<GetResponseCreatePostDomain> =
//        getCloudDataSource.getOnePost(objectId = objectId)
//            .map(mapPostResponseDataToPostResponseDomain::map)
//            .flowOn(Dispatchers.Default)
//


    override fun getComments(idPost: String): Flow<GetResponseListCommentsDomain> =
        getCloudDataSource.getComments(idPost = idPost)
            .map(mapGetCommentResponse::map)
            .flowOn(Dispatchers.Default)

    override fun getAllComments(): Flow<GetResponseListCommentsDomain> =
        getCloudDataSource.getAllComments()
            .map(mapGetCommentResponse::map)
            .flowOn(Dispatchers.Default)
}
    