package com.example.myinstaclone.presentation.models.user_registration

import com.example.myinstaclone.presentation.models.user_post.PostUi

data class HomeScreenItemUi(
    val posts: List<PostUi> ,
    val users:List<UserSignInUi>
)