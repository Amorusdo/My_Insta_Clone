package com.example.myinstaclone.presentation.screens._delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myinstaclone.R

class DeleteUserAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_delete_user_account , container , false)
    }
}