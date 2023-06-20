package com.example.data._network.models.user_comment

import com.example.data._network.models.user_image.ImageCloud
import com.google.gson.annotations.SerializedName

data class UserCommentsCloud(
    @SerializedName("userName") val userName: String ,
    @SerializedName("textComments") val userComments: String ,
    @SerializedName("idPost") val idPostForComments: String ,
    @SerializedName("commentImageUser") val commentImageUser: ImageCloud? ,
    @SerializedName("date") val data: String
)