package com.example.data._network.models.search

import com.example.data._network.models.user_post.PostCloud
import com.google.gson.annotations.SerializedName

data class GetResponseCreatePostCloud (
    @SerializedName("results") val posts: List<PostCloud>
)