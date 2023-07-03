package com.example.myinstaclone.presentation.screens._home

import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_comment.GetResponseListCommentsDomain
import com.example.domain.domain.models.user_registration.HomeScreenItemDomain
import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import com.example.domain.domain.repository.cloud.GetRepository
import com.example.domain.domain.use_case.home.FetchAllHomeScreenItemsUseCase
import com.example.myinstaclone.presentation.adaptor.lisener.UsersItemClickListener
import com.example.myinstaclone.presentation.common.event.Event
import com.example.myinstaclone.presentation.models.user_comment.GetResponseListCommentsUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.screens._home.listener.ItemClickListener
import com.example.myinstaclone.presentation.screens._home.mapper.ItemHomeScreenMapperImpl
import com.example.myinstaclone.presentation.screens._home.router.HomeScreenRouter
import com.example.myinstaclone.presentation.utils.NavCommand
import com.example.myinstaclone.presentation.utils.NavigationCommand
import com.example.myinstaclone.presentation.utils.communication_from_navigation.NavigationCommunication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val repository: GetRepository ,
//    private val storageRepository: UserStorageRepository
    fetchAllHomeScreenItemsUseCase: FetchAllHomeScreenItemsUseCase ,
    private val mapUserDomainToUserUi: Mapper<UserRegistrationDomain , UserRegistrationUi> ,
    private val mapGetCommentResponse: Mapper<GetResponseListCommentsDomain , GetResponseListCommentsUi> ,
    private val router: HomeScreenRouter ,
    private val filteredHomeScreenMapper: ItemHomeScreenMapperImpl
) : ViewModel() , ItemClickListener , UsersItemClickListener {

    private var navigationCommunication = NavigationCommunication.Base()

    fun collectNavigation(owner: LifecycleOwner , observer: Observer<Event<NavigationCommand>>) =
        navigationCommunication.observe(owner = owner , observer = observer)

    private val _userMee: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val userMee: LiveData<UserRegistrationUi> get() = _userMee

    private val _user: MutableLiveData<UserRegistrationUi> = MutableLiveData()
    val user: LiveData<UserRegistrationUi> get() = _user

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    private var _navCommand = createMutableSharedFlowAsSingleLiveEvent<NavCommand>()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    //
    fun navigation(navDirections: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

    fun navigation(navCommand: NavCommand) = _navCommand.tryEmit(navCommand)

    fun <T : Any> createMutableSharedFlowAsSingleLiveEvent(): MutableSharedFlow<T> =
        MutableSharedFlow(0 , 1 , BufferOverflow.DROP_OLDEST)

    init {
//        checkSave()
    }

    val allFilteredItemsFlow =
        fetchAllHomeScreenItemsUseCase()
            .map { items -> mapToAdapterModel(items) }
            .onStart {}
            .flowOn(Dispatchers.Default)
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope , SharingStarted.Lazily , null)

    private fun mapToAdapterModel(items: HomeScreenItemDomain) =
        filteredHomeScreenMapper.map(
            items = items ,
            searchQuery = String() ,
            postItemClickListener = this ,
            usersItemClickListener = this
        )

    private fun handleError(exception: Throwable) {
//        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
    }

//    private fun checkSave() {
//        viewModelScope.launch {
//            kotlin.runCatching {
////                storageRepository.getUser()
//            }.onSuccess {
//                if (it.userFullName != "Default") {
//                    _user.value = mapUserDomainToUserUi.map(it)
//                }
//            }
//        }
//    }

    fun login(login: String , password: String) = viewModelScope.launch {
        kotlin.runCatching {
            repository.logIn(login = login , password = password)
        }
            .onSuccess {
                _user.value = mapUserDomainToUserUi.map(it)
//                storageRepository.saveUser(it)
            }
            .onFailure {
                _error.value = it.message
            }
    }

    fun userMe(sessionToken: String) = viewModelScope.launch {
        kotlin.runCatching {
            repository.userProfile(sessionToken)
        }
            .onSuccess {
                _userMee.value = mapUserDomainToUserUi.map(it)
            }
            .onFailure {
                _error.value = it.message
            }
    }


    fun getComment(idPost: String) = repository.getComments(idPost = idPost)
        .map(mapGetCommentResponse::map)
        .flowOn(Dispatchers.Default)
        .shareIn(viewModelScope , SharingStarted.Lazily , 0)


    private val getUserPostComments = MutableStateFlow("")


    val getAllComment = getUserPostComments.flatMapLatest {
        repository.getAllComments()
            .map(mapGetCommentResponse::map)
            .flowOn(Dispatchers.Default)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)
    }

    override fun onClick() {
    }

    override fun onShatItemClick(postId: String) {
        navigation(router.navigateToCommentFragment(postId))
    }


}

