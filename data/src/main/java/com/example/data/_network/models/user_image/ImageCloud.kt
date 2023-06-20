package com.example.data._network.models.user_image

import com.google.gson.annotations.SerializedName

data class ImageCloud(
    @SerializedName("__type") val type: String = "File" ,
    @SerializedName("name") val imageName: String? = null ,
    @SerializedName("url") val imageUrl: String? = null
)