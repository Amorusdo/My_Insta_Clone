package com.example.data._network.sourse.put

import com.example.data._network.api.PutApi
import com.example.data._network.models.user_post.PostCloud
import com.example.data._network.models.user_registration.UserRegistrationCloud
import com.example.data._network.models.user_registration.UserSignInCloud
import com.example.data.models.user_post.PostData
import com.example.data.models.user_registration.UserRegistrationData
import com.example.data.models.user_registration.UserSignInData
import com.example.domain.domain.interfaces.Mapper

class PutCloudDataSourceImpl(
    private val api: PutApi ,
    private val mapPostDataToCloud: Mapper<PostData , PostCloud> ,
    private val mapPostCloudToData: Mapper<PostCloud , PostData> ,
    private val mapUserDataToCloud: Mapper<UserRegistrationData , UserRegistrationCloud> ,
    private val mapUserCloudToData: Mapper<UserRegistrationCloud , UserRegistrationData> ,
    private val mapCloudUserToData: Mapper<UserSignInCloud , UserSignInData> ,
    private val mapUserSingUpCloudToData: Mapper<UserSignInData , UserSignInCloud> ,
) : PutCloudDataSource {

    override suspend fun upDatePost(id: String , post: PostData , sessionToken: String): PostData =
        mapPostCloudToData.map(
            api.updatePost(
                id = id ,
                post = mapPostDataToCloud.map(post) ,
                sessionToken = sessionToken
            )
        )

    override suspend fun updateUser(
        id: String ,
        user: UserRegistrationData ,
        sessionToken: String
    ): UserRegistrationData =
        mapUserCloudToData
            .map(
                api.updateUser(
                    id = id ,
                    user = mapUserDataToCloud.map(user) ,
                    sessionToken = sessionToken
                )
            )

    override suspend fun updateUserSignIn(
        id: String ,
        user: UserSignInData ,
    ): UserSignInData =
        mapCloudUserToData.map(
            api.updateUserSignIn(
                id = id ,
                user = mapUserSingUpCloudToData.map(user) ,
            )
        )
}





