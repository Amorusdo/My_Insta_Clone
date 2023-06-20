package com.example.data._network.api

import com.example.data._network.Endpoints.DELETE_ACCOUNT
import com.example.data._network.Endpoints.DELETE_POST
import com.example.data._network.Endpoints.DELETE_USER
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.Path

interface DeleteApi {
    @DELETE(DELETE_ACCOUNT)
    suspend fun deleteAccount(
        @Path("id") id: String
    ): Unit

    // dsfgdg
    @DELETE(DELETE_USER)
    suspend fun deleteAccountUser(
        @Header("X-Parse-Session-Token") sessionToken: String ,
        @Path("id") id: String
    ): Unit

    @DELETE(DELETE_POST)
    suspend fun deleteUserPost(
        @Path("id") id: String
    ): Unit
}