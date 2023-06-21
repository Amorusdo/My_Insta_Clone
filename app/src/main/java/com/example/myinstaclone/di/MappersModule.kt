package com.example.myinstaclone.di


import com.example.data._network.mapper_cloud.comment.*
import com.example.data._network.mapper_cloud.post.*
import com.example.data._network.mapper_cloud.user.*
import com.example.data._network.models.search.GetResponseCreatePostCloud
import com.example.data._network.models.user_comment.GetResponseListCommentsCloud
import com.example.data._network.models.user_comment.UserCommentsCloud
import com.example.data._network.models.user_image.ImageCloud
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.ResponseCloud
import com.example.data._network.models.user_registration.UpDataResponseCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.mapper_data.comment.*
import com.example.data.mapper_data.post.MapListDomainPostToListData
import com.example.data.mapper_data.user.*
import com.example.data.models.search.GetResponseCreatePostData
import com.example.data.models.user_comment.GetResponseListCommentsData
import com.example.data.models.user_comment.UserCommentsData
import com.example.data.models.user_image.ImageData
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.*
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_image.ImageDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.*
import com.example.myinstaclone.presentation.mapper.comment.*
import com.example.myinstaclone.presentation.mapper.post.MapDomainListPostToUi
import com.example.myinstaclone.presentation.mapper.post.MapListUiPostToListDomain
import com.example.myinstaclone.presentation.mapper.post.MapPostDomainToUi
import com.example.myinstaclone.presentation.mapper.post.MapPostUiToDomain
import com.example.myinstaclone.presentation.mapper.user.*
import com.example.myinstaclone.presentation.models.user_comment.GetResponseListCommentsUi
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.models.user_registration.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {


    ////////////////////////////// CLOUD MAP PROVIDES ////////////////////////////////////

    @Provides
    @Singleton
    fun provideMapGetResponseListCommentCloudToData(
        mapper: Mapper<List<UserCommentsCloud> , List<UserCommentsData>>
    ): Mapper<GetResponseListCommentsCloud , GetResponseListCommentsData> =
        MapGetResponseListCommentCloudToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserCommentCloudToData(mapper: Mapper<ImageCloud , ImageData>): Mapper<UserCommentsCloud , UserCommentsData> =
        MapUserCommentCloudToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentDataToCloud(mapper: Mapper<UserCommentsData , UserCommentsCloud>):
            Mapper<List<UserCommentsData> , List<UserCommentsCloud>> =
        MapListUserCommentDataToCloud(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentCloudToData(mapper: Mapper<UserCommentsCloud , UserCommentsData>):
            Mapper<List<UserCommentsCloud> , List<UserCommentsData>> =
        MapListUserCommentCloudToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserCommentDataToCloud(mapper: Mapper<ImageData , ImageCloud>): Mapper<UserCommentsData , UserCommentsCloud> =
        MapUserCommentDataToCloud(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapListGetOneRegisteredUserCloudToData(
        mapper: Mapper<UserSignInCloud , UserSignInData>
    ): Mapper<List<UserSignInCloud> , List<UserSignInData>> =
        MapListGetOneRegisteredUserCloudToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUpDataResponseCloudToData(): Mapper<UpDataResponseCloud , UpDataResponseData> =
        MapUpDataResponseCloudToData()

    @Provides
    @Singleton
    fun provideMapUserSingUpDataToCloud(
        mapper: Mapper<ImageData , ImageCloud>
    ): Mapper<UserSignInData , UserSignInCloud> = MapUserSingInDataToCloud(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserSingUpCloudToData(
        mapper: Mapper<ImageCloud , ImageData> ,
    ): Mapper<UserSignInCloud , UserSignInData> = MapUserSingInCloudToData(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapImageDataToCloud(): Mapper<ImageData , ImageCloud> =
        MapImageDataToCloud()

    @Provides
    @Singleton
    fun provideMapUserCloudResponseToData(): Mapper<ResponseCloud , ResponseData> =
        MapUserCloudResponseToData()

    @Provides
    @Singleton
    fun provideMapUserRegistrationCloudToData(mapper: Mapper<ImageCloud , ImageData>):
            Mapper<UserRegistrationCloud , UserRegistrationData> =
        MapUserRegistrationCloudToData(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapImageCloudToImageData(): Mapper<ImageCloud , ImageData> =
        MapImageCloudToImageData()

    @Provides
    @Singleton
    fun provideMapUserRegistrationDataToCloud(
        mapper: Mapper<ImageData , ImageCloud>
    ): Mapper<UserRegistrationData , UserRegistrationCloud> =
        MapUserRegistrationDataToCloud(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapCloudListPostToData(
        mapper: Mapper<PostCloud , PostData>
    ): Mapper<List<PostCloud> , List<PostData>> = MapCloudListPostToData(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapPostCloudToData(
        mapper: Mapper<ImageCloud , ImageData> ,
    ): Mapper<PostCloud , PostData> = MapPostCloudToData(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapPostDataToCloud(
        mapper: Mapper<ImageData , ImageCloud> ,
        mapComment: Mapper<List<UserCommentsData> , List<UserCommentsCloud>>
    ): Mapper<PostData , PostCloud> = MapPostDataToCloud(mapper = mapper)


//    @Provides
//    @Singleton
//    fun provideMapPostResponseCloudToPostResponseData(
//    ): Mapper<GetResponseCreatePostCloud , GetResponseCreatePostData> =
//        MapGetResponseCreatePostCloudToData()

    @Provides
    @Singleton
    fun provideMapListDataPostToListCloud(
        mapper: Mapper<PostData , PostCloud>
    ): Mapper<List<PostData> , List<PostCloud>> = MapListDataPostToListCloud(mapper = mapper)

    ////////////////////////////// DATA MAP PROVIDES ////////////////////////////////////

    @Provides
    @Singleton
    fun provideMapGetResponseListCommentDataToDomain(
        mapper: Mapper<List<UserCommentsData> , List<UserCommentsDomain>>
    ): Mapper<GetResponseListCommentsData , GetResponseListCommentsDomain> =
        MapGetResponseListCommentDataToDomain(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapUserCommentDataToDomain(
        mapper: Mapper<ImageData , ImageDomain>
    ): Mapper<UserCommentsData , UserCommentsDomain> =
        MapUserCommentDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentDataToDomain(mapper: Mapper<UserCommentsData , UserCommentsDomain>):
            Mapper<List<UserCommentsData> , List<UserCommentsDomain>> =
        MapListUserCommentDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentDomainToData(mapper: Mapper<UserCommentsDomain , UserCommentsData>):
            Mapper<List<UserCommentsDomain> , List<UserCommentsData>> =
        MapListUserCommentDomainToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserCommentDomainToData(
        mapper: Mapper<ImageDomain , ImageData>
    ): Mapper<UserCommentsDomain , UserCommentsData> =
        MapUserCommentDomainToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapGetOneRegisteredUserDataToDomain(
        mapper: Mapper<List<UserSignInData> , List<UserSignInDomain>>
    ):
            Mapper<UserGetOneRegisteredData , UserGetOneRegisteredDomain> =
        MapGetOneRegisteredUserDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListGetOneRegisteredUserDataToDomain(
        mapper: Mapper<UserSignInData , UserSignInDomain>
    ): Mapper<List<UserSignInData> , List<UserSignInDomain>> =
        MapListGetOneRegisteredUserDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListDomainPostToListData(
        mapper: Mapper<PostDomain , PostData>
    ): Mapper<List<PostDomain> , List<PostData>> = MapListDomainPostToListData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUpDataResponseDataToDomain(): Mapper<UpDataResponseData , UpDataResponseDomain> =
        MapUpDataResponseDataToDomain()

    @Provides
    @Singleton
    fun provideMapUserSingInDataToDomain(
        mapper: Mapper<ImageData , ImageDomain>
    ): Mapper<UserSignInData , UserSignInDomain> = MapUserSingInDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserSingInDomainToData(
        mapper: Mapper<ImageDomain , ImageData>
    ): Mapper<UserSignInDomain , UserSignInData> = MapUserSingInDomainToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapImageDomainToData(): Mapper<ImageDomain , ImageData> =
        MapImageDomainToData()

    @Provides
    @Singleton
    fun provideMapUserRegistrationDataToDomain(mapper: Mapper<ImageData , ImageDomain>):
            Mapper<UserRegistrationData , UserRegistrationDomain> =
        MapUserRegistrationDataToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapImageDataToDomain(): Mapper<ImageData , ImageDomain> =
        MapImageDataToDomain()

    @Provides
    @Singleton
    fun provideMapUserRegistrationDomainToData(
        mapper: Mapper<ImageDomain , ImageData>
    ): Mapper<UserRegistrationDomain , UserRegistrationData> =
        MapUserRegistrationDomainToData(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserResponseDataToDomain(): Mapper<ResponseData , ResponseDomain> =
        MapUserDataResponseToDomain()

//    @Provides
//    @Singleton
//    fun provideMapPostResponseDataToPostResponseDomain(
//        mapper: Mapper<List<PostData> , List<PostDomain>>
//    ): Mapper<GetResponseCreatePostData , GetResponseCreatePostDomain> =
//        MapPostResponseDataToPostResponseDomain(mapper = mapper)


    ////////////////////////////// PRESENTATION MAP PROVIDES ////////////////////////////////////

    @Provides
    @Singleton
    fun provideMapGetResponseListCommentDomainToUi(
        mapper: Mapper<List<UserCommentsDomain> , List<UserCommentsUi>>
    ): Mapper<GetResponseListCommentsDomain , GetResponseListCommentsUi> =
        MapGetResponseListCommentDomainToUi(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapUserCommentDomainToUi(mapper: Mapper<ImageDomain , ImageUi>): Mapper<UserCommentsDomain , UserCommentsUi> =
        MapUserCommentDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentDomainToUi(mapper: Mapper<UserCommentsDomain , UserCommentsUi>):
            Mapper<List<UserCommentsDomain> , List<UserCommentsUi>> =
        MapListUserCommentDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUserCommentUiToDomain(mapper: Mapper<UserCommentsUi , UserCommentsDomain>):
            Mapper<List<UserCommentsUi> , List<UserCommentsDomain>> =
        MapListUserCommentUiToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserCommentUiToDomain(mapper: Mapper<ImageUi , ImageDomain>): Mapper<UserCommentsUi , UserCommentsDomain> =
        MapUserCommentUiToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapGetOneRegisteredUserDomainToUi(mapper: Mapper<List<UserSignInDomain> , List<UserSignInUi>>):
            Mapper<UserGetOneRegisteredDomain , UserGetOneRegisteredUi> =
        MapGetOneRegisteredUserDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListGetOneRegisteredUserDomainToUi(
        mapper: Mapper<UserSignInDomain , UserSignInUi>
    ): Mapper<List<UserSignInDomain> , List<UserSignInUi>> =
        MapListGetOneRegisteredUserDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapListUiPostToListDomain(
        mapper: Mapper<PostUi , PostDomain>
    ): Mapper<List<PostUi> , List<PostDomain>> = MapListUiPostToListDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUpDataResponseDomainToUI(): Mapper<UpDataResponseDomain , UpDataResponseUi> =
        MapUpDomainResponseToUi()

    @Provides
    @Singleton
    fun provideMapUserSingUpDomainToUi(
        mapper: Mapper<ImageDomain , ImageUi>
    ): Mapper<UserSignInDomain , UserSignInUi> = MapUserSingInDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserSingUpUiToDomain(
        mapper: Mapper<ImageUi , ImageDomain>
    ): Mapper<UserSignInUi , UserSignInDomain> =
        MapUserSingInUiToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapPostDomainToUi(
        mapper: Mapper<ImageDomain , ImageUi> ,
    ): Mapper<PostDomain , PostUi> = MapPostDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapImageUiToDomain(): Mapper<ImageUi , ImageDomain> =
        MapImageUiToDomain()

    @Provides
    @Singleton
    fun provideMapImageDomainToImageUi(): Mapper<ImageDomain , ImageUi> =
        MapImageDomainToImageUi()

    @Provides
    @Singleton
    fun provideMapUserRegistrationDomainToUserUi(mapper: Mapper<ImageDomain , ImageUi>):
            Mapper<UserRegistrationDomain , UserRegistrationUi> =
        MapUserRegistrationDomainToUi(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapUserResponseDomainToUi(): Mapper<ResponseDomain , ResponseUi> =
        MapUserDomainResponseToUi()

    @Provides
    @Singleton
    fun provideMapUserRegistrationUiToDomain(
        mapper: Mapper<ImageUi , ImageDomain>
    ): Mapper<UserRegistrationUi , UserRegistrationDomain> =
        MapUserRegistrationUiToDomain(mapper = mapper)

    @Provides
    @Singleton
    fun provideMapDomainListPostToUi(
        mapper: Mapper<PostDomain , PostUi>
    ): Mapper<List<PostDomain> , List<PostUi>> = MapDomainListPostToUi(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapPostUiToDomain(
        mapper: Mapper<ImageUi , ImageDomain> ,
    ): Mapper<PostUi , PostDomain> = MapPostUiToDomain(mapper = mapper)


    @Provides
    @Singleton
    fun provideMapGetResponseCreatePostCloudToData(
        mapper: Mapper<List<PostCloud> , List<PostData>> ,
    ): Mapper<GetResponseCreatePostCloud , GetResponseCreatePostData> =
        MapGetResponseCreatePostCloudToData(mapper = mapper)


    ////////////////////////////// STORAGE MAP PROVIDES ////////////////////////////////////

//    @Provides
//    @Singleton
//    fun provideMapListStorageToListData(
//        mapper: Mapper<PostData , PostStorage>
//    ): Mapper<List<PostData> , List<PostStorage>> = MapListStorageToListData(mapper = mapper)
//
//    @Provides
//    @Singleton
//    fun provideMapListDataToListStorage(
//        mapper: Mapper<PostStorage , PostData>
//    ): Mapper<List<PostStorage> , List<PostData>> = MapListDataToListStorage(mapper = mapper)
//
//    @Provides
//    @Singleton
//    fun provideMapImageStorageToData(): Mapper<ImageUserStorage , ImageData> =
//        MapImageStorageToData()
//
//    @Provides
//    @Singleton
//    fun provideMapUserStorageToData(
//        mapper: Mapper<ImageUserStorage , ImageData>
//    ): Mapper<UserRegistrationStorage , UserRegistrationData> =
//        MapUserStorageToData(mapper = mapper)
//
//    @Provides
//    @Singleton
//    fun provideMapImageDataToStorage(): Mapper<ImageData , ImageUserStorage> =
//        MapImageDataToStorage()
//
//    @Provides
//    @Singleton
//    fun provideMapUserRegistrationDataToStorage(
//        mapper: Mapper<ImageData , ImageUserStorage>
//    ): Mapper<UserRegistrationData , UserRegistrationStorage> =
//        MapUserRegistrationDataToStorage(mapper = mapper)


//    @Provides
//    @Singleton
//    fun provideMapPostData(
//        mapper: Mapper<ImageUserStorage , ImageData> ,
//    ): Mapper<PostStorage , PostData> = MapPostData(mapper = mapper)
//
//    @Provides
//    @Singleton
//    fun provideMapPostStorage(
//        mapper: Mapper<ImageData , ImageUserStorage> ,
//    ): Mapper<PostData , PostStorage> = MapPostStorage(mapper = mapper)
}