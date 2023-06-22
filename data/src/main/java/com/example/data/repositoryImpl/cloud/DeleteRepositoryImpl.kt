package com.example.data.repositoryImpl.cloud

import com.example.data._network.sourse.delete.DeleteCloudDataSource
import com.example.domain.domain.repository.cloud.DeleteRepository
import kotlinx.coroutines.flow.Flow

class DeleteRepositoryImpl(
    private val userCloudDataSource: DeleteCloudDataSource ,
) : DeleteRepository {

    override fun deleteAccount(id: String): Flow<Unit> =
        userCloudDataSource.deleteAccount(id = id)

    override fun deleteUserPost(id: String): Flow<Unit> =
        userCloudDataSource.deleteUserPost(id = id)

    override fun deleteAccountUser(id: String , sessionToken: String): Flow<Unit> =
        userCloudDataSource.deleteAccountUser(id = id , sessionToken = sessionToken)


}
    