package com.example.myinstaclone.presentation.all.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.repository.cloud.DeleteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class DeleteViewModel @Inject constructor(
    private val repository: DeleteRepository ,
    ) : ViewModel() {

    fun delete(id: String) = repository.deleteAccount(id = id)
        .shareIn(viewModelScope , SharingStarted.Lazily , 0)

    fun deleteUserPost(id: String) = repository.deleteUserPost(id = id)
        .shareIn(viewModelScope , SharingStarted.Lazily , 0)

    fun deleteUser(id: String , sessionToken: String) =
        repository.deleteAccountUser(id = id , sessionToken = sessionToken)
            .shareIn(viewModelScope , SharingStarted.Lazily , 0)

}

