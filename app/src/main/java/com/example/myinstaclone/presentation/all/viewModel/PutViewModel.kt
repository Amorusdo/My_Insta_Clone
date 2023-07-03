package com.example.myinstaclone.presentation.all.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.domain.domain.repository.cloud.PutRepository
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PutViewModel @Inject constructor(
    private val repository: PutRepository ,
    private val mapUser: Mapper<UserRegistrationDomain , UserRegistrationUi> ,
    private val mapUserUi: Mapper<UserRegistrationUi , UserRegistrationDomain> ,
    private val mapUserSingUpUiToDomain: Mapper<UserSignInUi , UserSignInDomain> ,
    private val mapUserSingDomainToUi: Mapper<UserSignInDomain , UserSignInUi> ,
    private val mapPostUi: Mapper<PostUi , PostDomain> ,
    private val mapPost: Mapper<PostDomain , PostUi> ,
//    private val storageRepository: UserStorageRepository
) : ViewModel() {

    private val _user: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val user: LiveData<UserRegistrationUi> get() = _user

    private val _userUpData: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val userUpData: LiveData<UserRegistrationUi> get() = _userUpData


    private val _postUpUi: MutableLiveData<PostUi> = MutableLiveData()
    val postUpUi: LiveData<PostUi> get() = _postUpUi

    private val _userUpDataSingIn: MutableLiveData<UserSignInUi> = MutableLiveData()
    val userUpDataSingIn: LiveData<UserSignInUi> get() = _userUpDataSingIn

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

//    init {
//        checkSave()
//    }
//
//    private fun checkSave() {
//        viewModelScope.launch {
//            kotlin.runCatching {
//                storageRepository.getUser()
//            }.onSuccess {
//                if (it.userFullName != "Default") {
//                    _user.value = mapUser.map(it)
//                }
//            }
//        }
//    }

    fun upDateUser(id: String , userUi: UserRegistrationUi , sessionToken: String) =
        viewModelScope.launch {
            kotlin.runCatching {
                repository.updateUser(
                    id = id ,
                    user = mapUserUi.map(userUi) ,
                    sessionToken = sessionToken
                )
            }
                .onSuccess {
                    _userUpData.value = mapUser.map(it)
                }
                .onFailure {
                    _error.value = it.message
                }
        }

    fun upDateUserSing(id: String , userUi: UserSignInUi) =
        viewModelScope.launch {
            kotlin.runCatching {
                repository.updateUserSignIn(
                    id = id ,
                    user = mapUserSingUpUiToDomain.map(userUi) ,
                )
            }
                .onSuccess {
                    _userUpDataSingIn.value = mapUserSingDomainToUi.map(it)
                }
                .onFailure {
                    _error.value = it.message
                }
        }

    fun upDataPost(id: String , post: PostUi , sessionToken: String) =
        viewModelScope.launch {
            kotlin.runCatching {
                repository.upDatePost(
                    id = id ,
                    post = mapPostUi.map(post) ,
                    sessionToken = sessionToken
                )
            }.onSuccess { _postUpUi.value = mapPost.map(it) }
                .onFailure { _error.value = it.message }
        }
}





