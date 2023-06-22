package com.example.myinstaclone.di

import com.example.data._network.sourse.delete.DeleteCloudDataSource
import com.example.data._network.sourse.post.PostCloudDataSours
import com.example.data._network.sourse.put.PutCloudDataSource
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.ResponseData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.data.repositoryImpl.cloud.DeleteRepositoryImpl
import com.example.data.repositoryImpl.cloud.PostRepositoryImpl
import com.example.data.repositoryImpl.cloud.PutRepositoryImpl
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.ResponseDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.DeleteRepository
import com.example.domain.domain.repository.cloud.PostRepository
import com.example.domain.domain.repository.cloud.PutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)

class RepositoryModule {

    @Provides
    fun providePostRepository(
        postCloudDataSource: PostCloudDataSours ,
        mapPostDomainToData: Mapper<PostDomain , PostData> ,
        mapCreatePostResponseDataToDomain: Mapper<ResponseData , ResponseDomain> ,
        mapUserToData: Mapper<UserRegistrationDomain , UserRegistrationData> ,
        mapUserSignUpToData: Mapper<UserSignInDomain , UserSignInData> ,
        mapUserResponse: Mapper<ResponseData , ResponseDomain> ,
        mapUserSignUpDataTo: Mapper<ResponseData , ResponseDomain> ,
        mapComment: Mapper<UserCommentsDomain , UserCommentsData> ,
        mapCommentResponse: Mapper<ResponseData , ResponseDomain> ,
    ): PostRepository = PostRepositoryImpl(
        postCloudDataSource = postCloudDataSource ,
        mapPostDomainToData = mapPostDomainToData ,
        mapCreatePostResponseDataToDomain = mapCreatePostResponseDataToDomain ,
        mapUserToData = mapUserToData ,
        mapUserSignUpToData = mapUserSignUpToData ,
        mapUserResponse = mapUserResponse ,
        mapUserSignUpDataTo = mapUserSignUpDataTo ,
        mapComment = mapComment ,
        mapCommentResponse = mapCommentResponse ,
    )


    @Provides
    fun providePutRepositoryImpl(
        putCloudDataSource: PutCloudDataSource ,
        mapUserToData: Mapper<UserRegistrationDomain , UserRegistrationData> ,
        mapUserSignUpToData: Mapper<UserSignInDomain , UserSignInData> ,
        mapUserSignUpDataToDomain: Mapper<UserSignInData , UserSignInDomain> ,
        mapDataUserToDomain: Mapper<UserRegistrationData , UserRegistrationDomain> ,
        mapPostDomainToData: Mapper<PostDomain , PostData> ,
        mapPostDataToDomain: Mapper<PostData , PostDomain> ,
    ): PutRepository = PutRepositoryImpl(
        putCloudDataSource = putCloudDataSource ,
        mapUserToData = mapUserToData ,
        mapUserSignUpToData = mapUserSignUpToData ,
        mapUserSignUpDataToDomain = mapUserSignUpDataToDomain ,
        mapDataUserToDomain = mapDataUserToDomain ,
        mapPostDomainToData = mapPostDomainToData ,
        mapPostDataToDomain = mapPostDataToDomain ,
    )

    @Provides
    fun provideDeleteRepositoryImpl(
        userCloudDataSource: DeleteCloudDataSource ,
    ): DeleteRepository = DeleteRepositoryImpl(
        userCloudDataSource = userCloudDataSource
    )
}