package com.example.myinstaclone.presentation.all.viewModel

import androidx.lifecycle.*
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.UserCommentsDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.ResponseDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.PostRepository
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.models.user_registration.ResponseUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository ,
    private val mapUserToDomain: Mapper<UserRegistrationUi , UserRegistrationDomain> ,
    private val mapUserSingUpUiToDomain: Mapper<UserSignInUi , UserSignInDomain> ,
    private val mapUserResponse: Mapper<ResponseDomain , ResponseUi> ,
    private val mapUserSignInResponse: Mapper<ResponseDomain , ResponseUi> ,
    private val mapPostResponseDomain: Mapper<ResponseDomain , ResponseUi> ,
    private val mapPostUi: Mapper<PostUi , PostDomain> ,
    private val mapCommentUiToDomain: Mapper<UserCommentsUi , UserCommentsDomain> ,
    private val mapCommentResponseDomainToCommentResponseUi: Mapper<ResponseDomain , ResponseUi> ,
) : ViewModel() {

    private val _post: MutableLiveData<ResponseUi> = MutableLiveData()
    val post: LiveData<ResponseUi> get() = _post

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private val postUser = MutableStateFlow("")


    fun createPost(postUi: PostUi) = postUser.flatMapLatest {
        repository.createPost(
            mapPostUi.map(postUi)
        ).map(mapPostResponseDomain::map)
            .flowOn(Dispatchers.Default)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)
    }

    private val singUpUser = MutableStateFlow("")

    fun signUpUser(user: UserRegistrationUi) = singUpUser.flatMapLatest {
        repository.userSignUp(
            mapUserToDomain.map(user)
        ).map(mapUserResponse::map)
            .flowOn(Dispatchers.Default)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)
    }

    private val singInUser = MutableStateFlow("")
    fun singIn(user: UserSignInUi) = singInUser.flatMapLatest {
        repository.singIn(
            mapUserSingUpUiToDomain.map(user)
        ).map(mapUserSignInResponse::map)
            .flowOn(Dispatchers.Default)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)
    }

    private val postCommentUser = MutableStateFlow("")

    fun createComment(comment: UserCommentsUi) = postCommentUser.flatMapLatest {
        repository.postComments(
            mapCommentUiToDomain.map(comment)
        ).map(mapCommentResponseDomainToCommentResponseUi::map)
            .flowOn(Dispatchers.Default)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)
    }

}