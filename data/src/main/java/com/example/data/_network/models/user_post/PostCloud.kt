package com.example.data._network.models.user_post

import com.example.data._network.models.user_image.ImageCloud
import com.google.gson.annotations.SerializedName

data class PostCloud(
    @SerializedName("objectId") val objectsId: String? ,
    @SerializedName("postImage")  val postImage: ImageCloud? ,
    @SerializedName("description") val description: String ,
    @SerializedName("postId") val postId: String ,
    @SerializedName("avatar")  val avatarName: ImageCloud? ,
    @SerializedName("userPostImage")  val userImagePost: String? ,
    @SerializedName("postHolderName")  val postHolderName: String? ,
    @SerializedName("likes")  val likes: Int ,
)