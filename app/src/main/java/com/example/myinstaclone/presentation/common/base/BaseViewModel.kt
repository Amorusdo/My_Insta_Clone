package com.example.myinstaclone.presentation.common.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myinstaclone.presentation.common.IdResourceString
import com.example.myinstaclone.presentation.common.communication.NavigationCommunication
import com.example.myinstaclone.presentation.common.event.Event
import com.example.myinstaclone.presentation.utils.NavCommand
import com.example.myinstaclone.presentation.utils.NavigationCommand
import com.example.myinstaclone.presentation.common.dispatchers.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel : ViewModel() {

    private var navigationCommunication = NavigationCommunication.Base()

    private var _navCommand = createMutableSharedFlowAsSingleLiveEvent<NavCommand>()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    private val _isErrorMessageIdFlow = createMutableSharedFlowAsSingleLiveEvent<IdResourceString>()
    val isErrorMessageIdFlow: SharedFlow<IdResourceString> get() = _isErrorMessageIdFlow.asSharedFlow()

    private var dispatchers = Dispatchers.Base()

    fun <T : Any> createMutableSharedFlowAsSingleLiveEvent(): MutableSharedFlow<T> =
        MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)

    fun collectNavigation(owner: LifecycleOwner, observer: Observer<Event<NavigationCommand>>) =
        navigationCommunication.observe(owner = owner, observer = observer)

    fun navigate(navCommand: NavCommand) = _navCommand.tryEmit(navCommand)

    fun navigateBack() =
        launchInBackground { navigationCommunication.put(Event(value = NavigationCommand.Back)) }

    fun emitToErrorMessageFlow(messageId: IdResourceString) =
        _isErrorMessageIdFlow.tryEmit(messageId)



    fun <T> launchInBackground(backgroundCall: suspend () -> T) =
        dispatchers.launchInBackground(viewModelScope) { backgroundCall() }

    companion object {
        const val SEARCH_DEBOUNCE = 300L
    }

}