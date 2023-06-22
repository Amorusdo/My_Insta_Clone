package com.example.data._network.sourse.delete

import com.example.data._network.api.DeleteApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DeleteCloudDataSourceImpl(
    private val api: DeleteApi ,
) : DeleteCloudDataSource {

    override fun deleteAccount(id: String): Flow<Unit> = flow {
        emit(api.deleteAccount(id = id))
    }.flowOn(Dispatchers.IO)

    override fun deleteUserPost(id: String): Flow<Unit> = flow {
        emit(api.deleteUserPost(id = id))
    }.flowOn(Dispatchers.IO)

    override fun deleteAccountUser(id: String , sessionToken: String): Flow<Unit> = flow {
        emit(api.deleteAccountUser(id = id , sessionToken = sessionToken))
    }.flowOn(Dispatchers.IO)

}





