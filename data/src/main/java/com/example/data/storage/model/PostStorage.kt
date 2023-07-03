package com.example.data.storage.model

class PostStorage(
    val objectsId: String? ,
    val postImage: ImageUserStorage ?,
    val description: String ,
    val postId: String? ,
    val avatarName: ImageUserStorage? ,
    val userImagePost: String? ,
    val postHolderName: String? ,
    val likes: Int
)