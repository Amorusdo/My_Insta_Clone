package com.example.data.storage.sourse

//import com.example.data.models.user_registration.UserRegistrationData
//import com.example.data.storage.model.UserRegistrationStorage
//import com.example.domain.domain.interfaces.Mapper
//import com.example.domain.domain.models.user_registration.UserRegistrationDomain
//import com.example.domain.domain.repository.storage.UserStorageRepository
//import javax.inject.Inject
//
//class StorageDataSourceImpl @Inject constructor(
//    private val mapToStorage: Mapper<UserRegistrationData , UserRegistrationStorage> ,
//    private val mapFromStorage: Mapper<UserRegistrationStorage , UserRegistrationData>
//) : UserStorageRepository {
//
////    override suspend fun saveUser(user: UserRegistrationData) {
////        val savedUser: String = Gson().toJson(mapToStorage.map(user))
////        sharedPref.edit().putString(SAVED_USER_NAME , savedUser).apply()
////        Log.d("SAVE" , user.userFullName)
////    }
////
////    override suspend fun getUser(): UserRegistrationData {
////        val savedUser = sharedPref.getString(SAVED_USER_NAME , null)
////        return mapFromStorage.map(Gson().fromJson(savedUser , UserRegistrationStorage::class.java))
////    }
////
////    override suspend fun removeUser() {
////        sharedPref.edit().clear().apply()
////    }
////
////    companion object {
////        const val SHARED_PREFER_NAME = "USER_SHARED_PREF"
////        const val SAVED_USER_NAME = "save_user_name"
////    }
//
//    override suspend fun saveUser(user: UserRegistrationDomain): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getUser(): UserRegistrationDomain {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun removeUser() {
//        TODO("Not yet implemented")
//    }
//}