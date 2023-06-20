package com.example.data._network.models.user_image

import com.google.gson.annotations.SerializedName

data class GetResponseCreateImagesPostCloud(
   @SerializedName("image") val image: ImageCloud
)