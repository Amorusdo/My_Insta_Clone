package com.example.data._network.api

import com.example.data._network.Endpoints.PUT_UP_DATA_POST
import com.example.data._network.Endpoints.PUT_USER_UP_DATA
import com.example.data._network.Endpoints.PUT_USER_UP_DATA_SING_IN
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Path

interface PutApi {

    @PUT(PUT_UP_DATA_POST)
    suspend fun updatePost(
        @Header("X-Parse-Session-Token") sessionToken: String ,
        @Path("id") id: String ,
        @Body post: PostCloud ,
    ): PostCloud

    @PUT(PUT_USER_UP_DATA)
    suspend fun updateUser(
        @Header("X-Parse-Session-Token") sessionToken: String ,
        @Path("id") id: String ,
        @Body user: UserRegistrationCloud ,
    ): UserRegistrationCloud

    @PUT(PUT_USER_UP_DATA_SING_IN)
    suspend fun updateUserSignIn(
        @Path("id") id: String ,
        @Body user: UserSignInCloud ,
    ): UserSignInCloud

}