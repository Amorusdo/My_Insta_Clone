package com.example.data.models.user_registration

import com.example.data.models.user_post.PostData

data class HomeScreenItemData(
    val posts: List<PostData> ,
    val users:List<UserSignInData>
)