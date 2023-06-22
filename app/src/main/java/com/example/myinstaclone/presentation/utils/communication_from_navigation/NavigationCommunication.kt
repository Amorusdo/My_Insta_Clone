package com.example.myinstaclone.presentation.utils.communication_from_navigation

import com.example.myinstaclone.presentation.utils.NavigationCommand
import com.example.myinstaclone.presentation.common.communication.Communication
import com.example.myinstaclone.presentation.common.event.Event
import javax.inject.Inject

interface NavigationCommunication : Communication<Event<NavigationCommand>> {
    class Base @Inject constructor() : Communication.Base<Event<NavigationCommand>>() ,
        NavigationCommunication
}
