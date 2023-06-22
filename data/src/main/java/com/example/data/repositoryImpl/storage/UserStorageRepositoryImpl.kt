package com.example.data.repositoryImpl.storage

import android.content.Context
import com.example.data.models.user_registration.UserRegistrationData
import com.example.domain.domain.interfaces.Mapper
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//class UserStorageRepositoryImpl @Inject constructor(
//    private val context: Context ,
//    private val mapFromDomainToStore: Mapper<UserRegistrationData , UserRegistrationStorage> ,
//    private val mapFromStoreToDomain: Mapper<UserRegistrationStorage , UserRegistrationData>
//) : UserStorageRepositoryData {
//
//    override suspend fun saveUser(user: UserRegistrationData) = context
//        .getSharedPreferences(SAVED_USER_NAME , Context.MODE_PRIVATE)
//        .edit()
//        .putString(SHARED_PREFER_NAME , Gson().toJson(mapFromDomainToStore.map(user)))
//        .commit()
//
//    override fun getUser(): Flow<UserRegistrationData> = flow {
//        val prev =
//            context.getSharedPreferences(SAVED_USER_NAME , Context.MODE_PRIVATE)
//        val userSaveModel = Gson()
//            .fromJson(
//                prev.getString(SHARED_PREFER_NAME , null) ,
//                UserRegistrationStorage::class.java
//            ) ?: UserRegistrationStorage.unkown()
//        emit(mapFromStoreToDomain.map(userSaveModel))
//    }
////
////    override suspend fun removeUser() = context
////        .getSharedPreferences(SHARED_PREFER_NAME , Context.MODE_PRIVATE)
////        .edit().clear().apply()
//
//    companion object {
//        const val SHARED_PREFER_NAME = "USER_SHARED_PREF"
//        const val SAVED_USER_NAME = "save_user_name"
//    }

//}
