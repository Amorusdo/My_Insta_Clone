package com.example.data._network.models.user_registration

import com.example.data._network.models.user_image.ImageCloud
import com.google.gson.annotations.SerializedName

data class UserSignInCloud(
    @SerializedName("objectId") val id: String ,
    @SerializedName("username") val userFullName: String ,
    @SerializedName("userEmail") val userEmail: String ,
    @SerializedName("userAge") val userAge: String? ,
    @SerializedName("gender") val userGender: Boolean? ,
    @SerializedName("phoneNumber") val phoneNumber: String? ,
    @SerializedName("userBio") val userBio: String? ,
    @SerializedName("userFollower") val userFollower: Int? ,
    @SerializedName("userFollowing") val userFollowing: Int? ,
    @SerializedName("userPosts") val userCountPosts: Int? ,
    @SerializedName("userAvatar") val userAvatar: ImageCloud ,
    @SerializedName("userId") val userId: String? ,
)