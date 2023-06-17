package com.example.domain.domain.models.search

import com.example.domain.domain.models.user_post.PostDomain

data class SearchPostsDomain (
    val posts: List<PostDomain>
)