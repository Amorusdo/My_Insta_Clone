package com.example.domain.domain.repository.storage

import com.example.domain.domain.models.user_registration.UserRegistrationDomain
import kotlinx.coroutines.flow.Flow


interface UserStorageRepository {

    suspend fun saveUser(user: UserRegistrationDomain): Boolean

     fun getUser(): Flow<UserRegistrationDomain>

    suspend fun removeUser()
}