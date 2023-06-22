package com.example.myinstaclone.presentation.common.communication

import com.example.myinstaclone.presentation.common.event.Event
import com.example.myinstaclone.presentation.utils.NavigationCommand

interface NavigationCommunication : Communication<Event<NavigationCommand>> {
    class Base : Communication.Base<Event<NavigationCommand>>() , NavigationCommunication
}
