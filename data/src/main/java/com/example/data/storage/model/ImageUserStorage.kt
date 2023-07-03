package com.example.data.storage.model

class ImageUserStorage(
    val type: String = "File" ,
    val imageName: String? = null ,
    val imageUrl: String? = null
) {
    companion object {
        fun unkown() = ImageUserStorage(
            type = String() ,
            imageName = String() ,
            imageUrl = String() ,
        )
    }
}