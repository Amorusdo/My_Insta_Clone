package com.example.myinstaclone.di

import com.example.data._network.api.DeleteApi
import com.example.data._network.api.GetApi
import com.example.data._network.api.PostApi
import com.example.data._network.api.PutApi
import com.example.data._network.models.search.GetResponseCreatePostCloud
import com.example.data._network.models.user_comment.GetResponseListCommentsCloud
import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.ResponseCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data._network.sourse.delete.DeleteCloudDataSource
import com.example.data._network.sourse.delete.DeleteCloudDataSourceImpl
import com.example.data._network.sourse.get.GetCloudDataSource
import com.example.data._network.sourse.get.GetCloudDataSourceImpl
import com.example.data._network.sourse.post.PostCloudDataSours
import com.example.data._network.sourse.post.PostCloudDataSoursImpl
import com.example.data._network.sourse.put.PutCloudDataSource
import com.example.data._network.sourse.put.PutCloudDataSourceImpl
import com.example.data.models.search.GetResponseCreatePostData
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.ResponseData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class SourceModule {
    @Provides
    fun provideUserCloudDataSource(
        api: GetApi ,
        mapUserCloudToData: Mapper<UserSignInCloud , UserSignInData> ,
        mapUserCloudToDataLogin: Mapper<UserRegistrationCloud , UserRegistrationData> ,
        mapPostResponseCloud: Mapper<GetResponseCreatePostCloud , GetResponseCreatePostData> ,
        postCloudToDataMapper: Mapper<PostCloud , PostData> ,
        mapGetCommentResponse: Mapper<GetResponseListCommentsCloud , GetResponseListCommentsData> ,

        ): GetCloudDataSource = GetCloudDataSourceImpl(
        api = api ,
        mapUserCloudToData = mapUserCloudToData ,
        mapUserCloudToDataLogin = mapUserCloudToDataLogin ,
        mapPostResponseCloud = mapPostResponseCloud ,
        postCloudToDataMapper = postCloudToDataMapper ,
        mapGetCommentResponse = mapGetCommentResponse
    )

    @Provides
    fun providesPostCloudDatSours(
        api: PostApi ,
        mapUserDataToCloud: Mapper<UserRegistrationData , UserRegistrationCloud> ,
        mapUserSingUpCloudToData: Mapper<UserSignInData , UserSignInCloud> ,
        mapPostDataToCloud: Mapper<PostData , PostCloud> ,
        mapComment: Mapper<UserCommentsData , UserCommentsCloud> ,
        mapPostCommentResponse: Mapper<ResponseCloud , ResponseData> ,
    ): PostCloudDataSours = PostCloudDataSoursImpl(
        api = api ,
        mapPostDataToCloud = mapPostDataToCloud ,
        mapUserDataToCloud = mapUserDataToCloud ,

        mapUserSingUpCloudToData = mapUserSingUpCloudToData ,
        mapComment = mapComment ,
        mapPostCommentResponse = mapPostCommentResponse ,

        )


    @Provides
    fun providePutRepositoryImpl(
        api: PutApi ,
        mapPostDataToCloud: Mapper<PostData , PostCloud> ,
        mapPostCloudToData: Mapper<PostCloud , PostData> ,
        mapUserDataToCloud: Mapper<UserRegistrationData , UserRegistrationCloud> ,
        mapUserCloudToData: Mapper<UserRegistrationCloud , UserRegistrationData> ,
        mapCloudUserToData: Mapper<UserSignInCloud , UserSignInData> ,
        mapUserSingUpCloudToData: Mapper<UserSignInData , UserSignInCloud> ,
    ): PutCloudDataSource = PutCloudDataSourceImpl(
        api = api ,
        mapPostDataToCloud = mapPostDataToCloud ,
        mapPostCloudToData = mapPostCloudToData ,
        mapUserDataToCloud = mapUserDataToCloud ,
        mapUserCloudToData = mapUserCloudToData ,
        mapCloudUserToData = mapCloudUserToData ,
        mapUserSingUpCloudToData = mapUserSingUpCloudToData ,
    )

    @Provides
    fun provideDeleteCloudDataSourceImpl(
        api: DeleteApi ,
    ): DeleteCloudDataSource = DeleteCloudDataSourceImpl(
        api = api
    )
}