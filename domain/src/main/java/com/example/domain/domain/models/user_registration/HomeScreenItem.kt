package com.example.domain.domain.models.user_registration

import com.example.domain.domain.models.user_post.PostDomain

data class HomeScreenItem(
    val posts: List<PostDomain> ,
    val users:List<UserSignInDomain>
)