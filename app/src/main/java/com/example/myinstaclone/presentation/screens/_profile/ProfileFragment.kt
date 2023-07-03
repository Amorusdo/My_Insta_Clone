package com.example.myinstaclone.presentation.screens._profile

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.App
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentProfileBinding
import com.example.myinstaclone.databinding.ItemSpinerBinding
import com.example.myinstaclone.presentation.all.adapter.postsImages.PostImagesAdaptor
import com.example.myinstaclone.presentation.all.viewModel.DeleteViewModel
import com.example.myinstaclone.presentation.all.viewModel.PutViewModel
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ProfileFragment : Fragment(),
    PostImagesAdaptor.OnItemClickListenerImageProfile, PostImagesAdaptor.CountPost {

    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    private val adapterPost by lazy { PostImagesAdaptor(this,this) }
    private val viewModelLogin by viewModels<ViewModelHome>()
    private val viewModelPut by viewModels<PutViewModel>()
    private val viewModelGet by viewModels<ViewModelHome>()
    private val viewModelDelete by viewModels<DeleteViewModel>()

    private lateinit var userId: String
    private lateinit var email: String
    private lateinit var sessiontoken: String
    private lateinit var users: String


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.rvMyImages.adapter = adapterPost
        observeUser()
        userMeObserve()
        obUpData()
        clikers()
//       listImages()
        userMe()

    }

    private fun clikers() = with(binding) {
        chooseMenu.setOnClickListener {
//            openDialog()
        }
        editProfileBtn.setOnClickListener {
            observeUser()
            editProfile()
        }
        addFriend.setOnClickListener {
            goToAddFriends()
        }
    }

    private fun userMeObserve() {
        lifecycleScope.launchWhenResumed {
            viewModelGet.userMe(sessiontoken)
        }
    }

    private fun observeUser() {
        lifecycleScope.launchWhenCreated {
            viewModelLogin.user.observe(viewLifecycleOwner) {
                userId = it.objectId
                sessiontoken = it.sessionToken
                email = it.userEmail
            }
        }
    }

    private fun userMe()= with(binding){
        lifecycleScope.launchWhenCreated {
            viewModelGet.userMee.observe(viewLifecycleOwner) {
                toolbarProfileText.text = it.userEmail
                profileName.text = it.userFullName
                Picasso.get().load(it.userAvatar.imageUrl).into(imageProfile)
                profileBio.text = it.profileBio
                userId = it.objectId
                users = it.userSingInId

            }
        }
    }

//    private fun listImages()= with(binding) {
//        lifecycleScope.launchWhenResumed {
//            viewModelGet.oneUserPosts(postId = userId).collectLatest {
//                adapterPost.postsImages = it.posts.reversed()
//                val count = adapterPost.itemCount
//               numberPosts.text = count.toString()
//            }
//        }
//    }

    private fun deleteAccount() {
        lifecycleScope.launchWhenStarted {
            viewModelDelete.delete(id = users).collectLatest {
            }
        }
    }

    private fun deleteAccountUser() {
        lifecycleScope.launchWhenStarted {
            viewModelDelete.deleteUser(id = userId , sessionToken = sessiontoken).collectLatest {
            }
        }
    }

    private fun obUpData() {
        lifecycleScope.launchWhenCreated {
            viewModelPut.userUpData.observe(viewLifecycleOwner) {
                observeUser()
            }
        }
    }

    private fun editProfile() {
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment2())
    }

    private fun goToLogin() {
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToSignInFragment())
    }

    private fun goToAddFriends() {
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAllUserFragment())
    }

    private fun deletePost(id:String) {
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToDeleteUserAccountFragment(id))
    }

//    private fun openDialog() {
//        val dialogBinding = ItemSpinerBinding.inflate(layoutInflater)
//        dialogBinding.apply {
//            val dialog =
//                AlertDialog.Builder(requireContext()).setTitle("")
//                    .setView(root)
//                    .create()
//            dialog.setOnShowListener {
//                dialogBinding.singOut.setOnClickListener {
//                    dialog.dismiss()
//                    val sharedPref = App.instance.getSharedPreferences(
//                        StorageDataSourceImpl.SHARED_PREFER_NAME ,
//                        Context.MODE_PRIVATE
//                    )
//                    sharedPref.edit().remove(StorageDataSourceImpl.SAVED_USER_NAME).apply()
//                    goToLogin()
//                }
//                dialogBinding.deleteAccount.setOnClickListener {
//                    dialog.dismiss()
//                    deleteAccount()
//                    deleteAccountUser()
//                    val sharedPref = App.instance.getSharedPreferences(
//                        StorageDataSourceImpl.SHARED_PREFER_NAME ,
//                        Context.MODE_PRIVATE
//                    )
//                    sharedPref.edit().remove(StorageDataSourceImpl.SAVED_USER_NAME).apply()
//                    goToLogin()
//                }
//                dialog.show()
//
//                dialogBinding.back.setOnClickListener {
//                    dialog.dismiss()
//                }
//            }
//            dialog.show()
//            val window = dialog.window
//            window?.setLayout(600 , 450) // размеры диалогового окна
//            window?.setGravity(Gravity.TOP or Gravity.END) // позиция диалогового ок
//        }
//    }

    override fun onItemClick(position: Int , id: String ) {
        deletePost(id)
    }

    override fun countPost(position: Int , count: Int) {
        binding.numberPosts.text = count.toString()
    }

}