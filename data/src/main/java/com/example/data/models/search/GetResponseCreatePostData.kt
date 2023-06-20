package com.example.data.models.search

import com.example.data.models.user_post.PostData

data class GetResponseCreatePostData (
    val posts: List<PostData>
)