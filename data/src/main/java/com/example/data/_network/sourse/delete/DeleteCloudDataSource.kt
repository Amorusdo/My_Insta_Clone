package com.example.data._network.sourse.delete

import kotlinx.coroutines.flow.Flow

interface DeleteCloudDataSource {
    fun deleteAccount(id: String): Flow<Unit>
    fun deleteUserPost(id: String): Flow<Unit>
    fun deleteAccountUser(id: String , sessionToken: String): Flow<Unit>

}