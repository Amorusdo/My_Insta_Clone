package com.example.data._network.models.user_comment

import com.google.gson.annotations.SerializedName

data class GetResponseListCommentsCloud (
        @SerializedName("results") val comments: List<UserCommentsCloud>
        )