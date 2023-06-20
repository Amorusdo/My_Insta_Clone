package com.example.data._network.api

import com.example.data._network.Endpoints.COMMENT_GET
import com.example.data._network.Endpoints.GET_ONE_USER_POSTS
import com.example.data._network.Endpoints.GET_SEARCH_POSTS
import com.example.data._network.Endpoints.GET_USER_LOGIN
import com.example.data._network.Endpoints.GET_USER_ME
import com.example.data._network.Endpoints.GET_USER_REGISTERED
import com.example.data._network.Endpoints.POST_GET_ALL_POST
import com.example.data._network.models.search.GetResponseCreatePostCloud
import com.example.data._network.models.user_comment.GetResponseListCommentsCloud
import com.example.data._network.models.user_registration.UserGetOneRegisteredCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetApi {

    @GET(GET_USER_REGISTERED)
    suspend fun registeredUserAll(
        @Header("X-Parse-Revocable-Session") session: Int = 1 ,
    ): Response<UserGetOneRegisteredCloud>

    @GET(GET_USER_LOGIN)
    suspend fun login(
        @Header("X-Parse-Revocable-Session") session: Int = 1 ,
        @Query("username") login: String ,
        @Query("password") password: String ,
    ): UserRegistrationCloud

    @GET(GET_USER_ME)
    suspend fun userProfile(
        @Header("X-Parse-Session-Token") sessionToken: String ,
    ): UserRegistrationCloud

    @GET(POST_GET_ALL_POST)
    suspend fun getAllPost(
    ): Response<GetResponseCreatePostCloud>

    @GET(GET_ONE_USER_POSTS)
    suspend fun getPostsOneUser(
        @Query("where") postId: String
    ): Response<GetResponseCreatePostCloud>

    @GET(GET_SEARCH_POSTS)
    suspend fun getSearchByDescription(
        @Query("where") description: String
    ): Response<GetResponseCreatePostCloud>

    @GET(GET_ONE_USER_POSTS)
    suspend fun getOnePost(
        @Query("where") objectId: String
    ): GetResponseCreatePostCloud

    @GET(COMMENT_GET)
    suspend fun getPostAllComment(): GetResponseListCommentsCloud

    @GET(COMMENT_GET)
    suspend fun getPostComment(
        @Query("where") idPost: String
    ): GetResponseListCommentsCloud

}