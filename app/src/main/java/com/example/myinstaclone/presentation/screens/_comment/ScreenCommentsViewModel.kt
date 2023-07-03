package com.example.myinstaclone.presentation.screens._comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.repository.cloud.GetRepository
import com.example.myinstaclone.presentation.common.event.Event
import com.example.myinstaclone.presentation.models.user_comment.GetResponseListCommentsUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.utils.NavigationCommand
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ScreenCommentsViewModel @AssistedInject constructor(
    @Assisted private val idPost: String ,
    private val repository: GetRepository ,
//    private val userCache: UserStorageRepository ,
    private val mapUserDomainToUserUi: Mapper<UserRegistrationDomain , UserRegistrationUi> ,
    private val mapGetCommentResponse: Mapper<GetResponseListCommentsDomain , GetResponseListCommentsUi> ,
) : ViewModel() {

    private val _userMe: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val userMe: LiveData<UserRegistrationUi> get() = _userMe

    private val _user: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val user: LiveData<UserRegistrationUi> get() = _user

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private val idPostFlow = MutableStateFlow(idPost)
    fun navigation(navDirections: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

//    fun userMe() = viewModelScope.launch {
//        kotlin.runCatching {
//            userCache.getUser()
//        }.onSuccess { _userMe.value = mapUserDomainToUserUi.map(it) }
//            .onFailure { _error.value = it.message }
//    }


    val getComment = idPostFlow.flatMapLatest {
        repository.getComments(it)
    }.flowOn(Dispatchers.Default)
        .map(mapGetCommentResponse::map)
        .shareIn(viewModelScope , SharingStarted.Lazily , 0)

    @AssistedFactory
    interface Factory {
        fun create(idPost: String): ScreenCommentsViewModel
    }



//    val allFilteredItemsFlow =
//        fetchAllHomeScreenItemsUseCase()
//            .map { items -> mapToAdapterModel(items) }
//            .onStart {}
//            .flowOn(Dispatchers.Default)
//            .catch { exception: Throwable -> handleError(exception) }
//            .stateIn(viewModelScope , SharingStarted.Lazily , null)
//
//    private fun mapToAdapterModel(items: HomeScreenItems) =
//        filteredHomeScreenMapper.map(
//            items = items ,
//            searchQuery = String() ,
//            postItemClickListener = this ,
//            usersItemClickListener = this
//        )
//

}

