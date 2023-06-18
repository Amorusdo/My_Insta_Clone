package com.example.myinstaclone.presentation.screens._alluser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myinstaclone.R


class AllUserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_all_user , container , false)
    }
}