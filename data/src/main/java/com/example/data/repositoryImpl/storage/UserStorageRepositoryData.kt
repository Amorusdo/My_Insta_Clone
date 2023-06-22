package com.example.data.repositoryImpl.storage

import com.example.data.models.user_registration.UserRegistrationData
import kotlinx.coroutines.flow.Flow


interface UserStorageRepositoryData {

    suspend fun saveUser(user: UserRegistrationData): Boolean

    fun getUser(): Flow<UserRegistrationData>

    suspend fun removeUser()
}