package com.example.myinstaclone.presentation.screens._alluser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentAllUserBinding
import com.example.myinstaclone.presentation.all.adapter.addFriends.AddFriendsAdaptor
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllUserFragment : Fragment() {
    private val binding by lazy { FragmentAllUserBinding.inflate(layoutInflater) }
    private val adapterUsers by lazy { AddFriendsAdaptor() }
    private val viewModelLogin by viewModels<ViewModelHome>()
    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.allUser.adapter = adapterUsers
//        oneUserRegistered()
        observeUser()
        clikers()
    }

//    private fun oneUserRegistered() {
//        lifecycleScope.launchWhenStarted {
//            viewModelLogin.oneUserRegistered.collectLatest {
//                adapterUsers.signUser = it.userList.filter { it -> it.userEmail != email }
//            }
//        }
//    }

    private fun observeUser() {
        lifecycleScope.launchWhenStarted {
            viewModelLogin.user.observe(viewLifecycleOwner) {
                email = it.userEmail
            }
        }
    }

    private fun clikers() = with(binding) {
        closeImage.setOnClickListener {
            profile()
        }
    }

    private fun profile() {
        findNavController().popBackStack()
    }
}