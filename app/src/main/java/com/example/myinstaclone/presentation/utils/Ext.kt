package com.example.myinstaclone.presentation.utils

import androidx.navigation.NavController
import com.example.myinstaclone.presentation.utils.NavCommand

fun NavController.navigateTo(navCommand: NavCommand) {
    try {
        navigate(navCommand.resId, navCommand.args)
    } catch (_: java.lang.Exception) {
    }
}