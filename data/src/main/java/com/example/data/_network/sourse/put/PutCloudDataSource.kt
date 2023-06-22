package com.example.data._network.sourse.put

import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData

interface PutCloudDataSource {

    suspend fun upDatePost(id: String , post: PostData , sessionToken: String): PostData

    suspend fun updateUser(
        id: String ,
        user: UserRegistrationData ,
        sessionToken: String
    ): UserRegistrationData

    suspend fun updateUserSignIn(
        id: String ,
        user: UserSignInData ,
    ): UserSignInData

}