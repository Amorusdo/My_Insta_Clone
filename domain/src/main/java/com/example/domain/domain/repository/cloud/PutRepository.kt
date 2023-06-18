package com.example.domain.domain.repository.cloud

import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain

interface PutRepository {

    suspend fun upDatePost(id: String , post: PostDomain , sessionToken: String): PostDomain

    suspend fun updateUser(
        id: String ,
        user: UserRegistrationDomain ,
        sessionToken: String
    ): UserRegistrationDomain

    suspend fun updateUserSignIn(
        id: String ,
        user: UserSignInDomain ,
    ): UserSignInDomain

}