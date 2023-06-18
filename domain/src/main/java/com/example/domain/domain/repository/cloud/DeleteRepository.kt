package com.example.domain.domain.repository.cloud

import kotlinx.coroutines.flow.Flow

interface DeleteRepository {
    fun deleteAccount(id: String): Flow<Unit>
    fun deleteUserPost(id: String): Flow<Unit>
    fun deleteAccountUser(id: String,sessionToken: String): Flow<Unit>


}