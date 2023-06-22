package com.example.data._network.sourse.get

import com.example.data._network.api.GetApi
import com.example.data._network.models.search.GetResponseCreatePostCloud
import com.example.data._network.models.user_comment.GetResponseListCommentsCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.UserGetOneRegisteredCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.search.GetResponseCreatePostData
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetCloudDataSourceImpl(
    private val api: GetApi ,
    private val mapUserCloudToData: Mapper<UserSignInCloud , UserSignInData> ,
    private val mapUserCloudToDataLogin: Mapper<UserRegistrationCloud , UserRegistrationData> ,
    private val mapPostResponseCloud: Mapper<GetResponseCreatePostCloud , GetResponseCreatePostData> ,
    private val postCloudToDataMapper: Mapper<PostCloud , PostData> ,
    private val mapGetCommentResponse: Mapper<GetResponseListCommentsCloud , GetResponseListCommentsData> ,
) : GetCloudDataSource {

    override fun getAllPost(): Flow<List<PostData>> = flow {
        emit(api.getAllPost())
    }.flowOn(Dispatchers.IO)
        .map { it.body() ?: GetResponseCreatePostCloud(emptyList()) }
        .map { it.posts }
        .map { posts -> posts.map(postCloudToDataMapper::map) }
        .flowOn(Dispatchers.Default)

    override fun registeredUserAll(): Flow<List<UserSignInData>> = flow {
        emit(api.registeredUserAll())
    }.flowOn(Dispatchers.IO)
        .map { it.body() ?: UserGetOneRegisteredCloud(emptyList()) }
        .map { it.userList }
        .map { users -> users.map(mapUserCloudToData::map) }
        .flowOn(Dispatchers.Default)

    override fun getSearchByDescription(description: String): Flow<List<PostData>> = flow {
        emit(api.getSearchByDescription(description = "{ \"description\": \"${description}\" }"))
    }.flowOn(Dispatchers.IO)
        .map { it.body() ?: GetResponseCreatePostCloud(emptyList()) }
        .map { it.posts }
        .map { post -> post.map(postCloudToDataMapper::map) }
        .flowOn(Dispatchers.Default)

    override fun getPostsOneUser(postId: String): Flow<List<PostData>> = flow {
        emit(api.getPostsOneUser(postId = "{ \"postId\": \"${postId}\" }"))
    }.flowOn(Dispatchers.IO)
        .map { it.body() ?: GetResponseCreatePostCloud(emptyList()) }
        .map { it.posts }
        .map { post -> post.map(postCloudToDataMapper::map) }
        .flowOn(Dispatchers.Default)


    override suspend fun login(login: String , password: String): UserRegistrationData =
        mapUserCloudToDataLogin.map(api.login(login = login , password = password))

    override suspend fun userProfile(sessionToken: String): UserRegistrationData =
        mapUserCloudToDataLogin.map(api.userProfile(sessionToken = sessionToken))


    override fun getOnePost(objectId: String): Flow<GetResponseCreatePostData> = flow {
        emit(api.getOnePost(objectId = "{ \"objectId\": \"${objectId}\" }"))
    }
        .flowOn(Dispatchers.IO)
        .map(mapPostResponseCloud::map)
        .flowOn(Dispatchers.Default)

    //////////////////////////////////////////////////////////

    override fun getComments(idPost: String): Flow<GetResponseListCommentsData> = flow {
        emit(api.getPostComment(idPost = "{\"idPost\":\"${idPost}\"}"))
    }.flowOn(Dispatchers.IO)
        .map(mapGetCommentResponse::map)
        .flowOn(Dispatchers.Default)

    override fun getAllComments(): Flow<GetResponseListCommentsData> = flow {
        emit(api.getPostAllComment())
    }.flowOn(Dispatchers.IO)
        .map(mapGetCommentResponse::map)
        .flowOn(Dispatchers.Default)
}





