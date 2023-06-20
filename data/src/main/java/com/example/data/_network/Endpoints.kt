package com.example.data._network

object Endpoints {
    // userProfile

    const val GET_USER_LOGIN = "login"
    const val GET_USER_ME ="users/me"
    const val GET_USER_REGISTERED = "classes/RegisteredUsers"
    const val POST_USER_SING_UP = "users"
    const val POST_USER_REGISTERED = "classes/RegisteredUsers"
    const val PUT_USER_UP_DATA = "/users/{id}"
    const val PUT_USER_UP_DATA_SING_IN = "/classes/RegisteredUsers/{id}"
    const val DELETE_ACCOUNT= "classes/RegisteredUsers/{id}"
    const val DELETE_USER= "/users/{id}"

    //userPosts

    const val GET_SEARCH_POSTS = "classes/Post?"
    const val GET_ONE_USER_POSTS= "classes/Post"
    const val POST_CREATE_POST = "classes/Post"
    const val POST_GET_ALL_POST = "classes/Post?"
    const val PUT_UP_DATA_POST = "classes/Post/{id}"
    const val DELETE_POST= "classes/Post/{id}"


    //Comments
    const val COMMENT_POST = "classes/UserComments"
    const val COMMENT_GET = "classes/UserComments"
    const val COMMENT_PUT = "/classes/UserComments/{objectId}"
    const val COMMENT_DELETE ="/classes/UserComments/{objectId}"

}