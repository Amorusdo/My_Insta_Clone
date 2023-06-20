package com.example.data._network.models.user_registration

import com.google.gson.annotations.SerializedName

data class UserGetOneRegisteredCloud(
    @SerializedName("results") val userList: List<UserSignInCloud> ,
)