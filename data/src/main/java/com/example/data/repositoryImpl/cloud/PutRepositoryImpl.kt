package com.example.data.repositoryImpl.cloud

import com.example.data._network.sourse.put.PutCloudDataSource
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.PutRepository

class PutRepositoryImpl(
    private val putCloudDataSource: PutCloudDataSource ,
    private val mapUserToData: Mapper<UserRegistrationDomain , UserRegistrationData> ,
    private val mapUserSignUpToData: Mapper<UserSignInDomain , UserSignInData> ,
    private val mapUserSignUpDataToDomain: Mapper<UserSignInData , UserSignInDomain> ,
    private val mapDataUserToDomain: Mapper<UserRegistrationData , UserRegistrationDomain> ,
    private val mapPostDomainToData: Mapper<PostDomain , PostData> ,
    private val mapPostDataToDomain: Mapper<PostData , PostDomain> ,
) : PutRepository {

    override suspend fun upDatePost(
        id: String ,
        post: PostDomain ,
        sessionToken: String
    ): PostDomain =
        mapPostDataToDomain.map(
            putCloudDataSource.upDatePost(
                id = id ,
                mapPostDomainToData.map(post) ,
                sessionToken = sessionToken
            )
        )

    override suspend fun updateUser(
        id: String ,
        user: UserRegistrationDomain ,
        sessionToken: String
    ): UserRegistrationDomain =
        mapDataUserToDomain.map(
            putCloudDataSource.updateUser(
                id = id ,
                user = mapUserToData.map(user) ,
                sessionToken = sessionToken
            )
        )

    override suspend fun updateUserSignIn(
        id: String ,
        user: UserSignInDomain ,
    ): UserSignInDomain =
        mapUserSignUpDataToDomain.map(
            putCloudDataSource.updateUserSignIn(
                id = id ,
                user = mapUserSignUpToData.map(user) ,
            )
        )
}
    