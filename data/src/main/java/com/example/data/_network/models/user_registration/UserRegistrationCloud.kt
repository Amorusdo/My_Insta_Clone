package com.example.data._network.models.user_registration

import com.example.data._network.models.user_image.ImageCloud
import com.google.gson.annotations.SerializedName

data class UserRegistrationCloud(
    @SerializedName("objectId") val objectId: String ,
    @SerializedName("username") val userFullName: String ,
    @SerializedName("email") val userEmail: String ,
    @SerializedName("gender") val userGender: Boolean? ,
    @SerializedName("phoneNumber") val phoneNumber: String? ,
    @SerializedName("profileBio") val profileBio: String? ,
    @SerializedName("userFollower") val userFollower: Int? ,
    @SerializedName("userFollowing") val userFollowing: Int? ,
    @SerializedName("userPosts") val userCountPosts: Int? ,
    @SerializedName("userAvatar") val userAvatar: ImageCloud ,
    @SerializedName("password") val userPassword: String? ,
    @SerializedName("sessionToken") val sessionToken: String ,
    @SerializedName("userSingInId") val userSingInId: String ,
    @SerializedName("createUserAt") val createUserAt: String ,
)