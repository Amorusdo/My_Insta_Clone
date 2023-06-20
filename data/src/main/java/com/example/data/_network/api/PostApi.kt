package com.example.data._network.api

import com.example.data._network.Endpoints.COMMENT_POST
import com.example.data._network.Endpoints.POST_CREATE_POST
import com.example.data._network.Endpoints.POST_USER_REGISTERED
import com.example.data._network.Endpoints.POST_USER_SING_UP
import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.ResponseCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PostApi {

    @POST(POST_CREATE_POST)
    suspend fun createPost(
        @Body post: PostCloud
    ): ResponseCloud

    //////////////////////////////////////////////////

    @POST(POST_USER_SING_UP)
    suspend fun userSignUp(
        @Header("X-Parse-Revocable-Session") session: Int = 1 ,
        @Body user: UserRegistrationCloud ,
    ): ResponseCloud

    @POST(POST_USER_REGISTERED)
    suspend fun singIn(
        @Body user: UserSignInCloud ,
    ): ResponseCloud


//////////////////////////////////////////

    @POST(COMMENT_POST)
    suspend fun postComments(
        @Body comment: UserCommentsCloud ,
    ): ResponseCloud


}