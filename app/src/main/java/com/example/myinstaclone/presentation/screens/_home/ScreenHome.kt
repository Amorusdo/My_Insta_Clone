package com.example.myinstaclone.presentation.screens._home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.presentation.screens._home.blocks.PostBlockFingerprint
import com.example.myinstaclone.presentation.screens._home.blocks.UserBlockFingerprint
import com.example.myinstaclone.presentation.screens._home.fingerprints.PostFingerprint
import com.example.myinstaclone.presentation.screens._home.fingerprints.UserFingerprint
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentHomeBinding
import com.example.myinstaclone.presentation.adaptor.FingerprintAdapter
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.utils.NavigationCommand
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import com.example.myinstaclone.presentation.extantions.launchWhenViewStarted
import com.example.myinstaclone.presentation.extantions.showView
import com.example.myinstaclone.presentation.utils.navigateTo

@AndroidEntryPoint
class ScreenHome : Fragment() {
    private val binding by lazy {FragmentHomeBinding .inflate(layoutInflater) }
    private val viewModelHome by viewModels<ViewModelHome>()
    private val genericAdapter = FingerprintAdapter(
        listOf(
            PostBlockFingerprint(
                listOf(PostFingerprint()),
                RecyclerView.RecycledViewPool() ,
            ) ,
            UserBlockFingerprint(
                listOf(UserFingerprint()),
                RecyclerView.RecycledViewPool() ,
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeData()
        requireActivity().findViewById<BottomNavigationView>(R.id.main_bottom_nav_view).showView()
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.rvViewHome.adapter = genericAdapter
       observeData()

    }

    private fun observeData() = with(viewModelHome) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            navCommand.observe(findNavController()::navigateTo)
        }
        viewModelHome.navigation.observe(viewLifecycleOwner) {
            it.getValue()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }

        collectNavigation(viewLifecycleOwner) {
            it.getValue()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }
    private fun populateModels(items: Triple<List<Item> , List<Item> , List<Item>>) {
        genericAdapter.submitList(items.first.reversed())

    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection -> findNavController().navigate(navCommand.directions.actionId)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

//
//
//    private fun onSavePost(post: PostUi) {
//        val postIndex = .indexOf(post)
//        val newItem = post.copy(isSaved = post.isSaved.not())
//
//        postsList.removeAt(postIndex)
//        postsList.add(postIndex, newItem)
//        postAdapter.submitList(postsList.toList())
//    }
//
//    private fun oneUserRegistered() {
//        lifecycleScope.launchWhenStarted {
//            viewModelGet.oneUserRegistered.collectLatest {
//                friends.signUser = it.userList
//
//            }
//        }
//    }
//
//
//    private fun getComment() {
//        lifecycleScope.launchWhenCreated {
//            viewModelGet.getAllComment.collectLatest {
//                adapterPost.post = it.comments
//            }
//        }
//    }


}
