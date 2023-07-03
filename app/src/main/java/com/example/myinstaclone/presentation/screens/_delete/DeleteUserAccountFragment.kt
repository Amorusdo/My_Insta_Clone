package com.example.myinstaclone.presentation.screens._delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentDeleteUserAccountBinding
import com.example.myinstaclone.presentation.all.adapter.deleteImages.DeleteImagesAdaptor
import com.example.myinstaclone.presentation.all.viewModel.DeleteViewModel
import com.example.myinstaclone.presentation.extantions.hideView
import com.example.myinstaclone.presentation.extantions.makeToast
import com.example.myinstaclone.presentation.extantions.showView
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DeleteUserAccountFragment : Fragment() {

    private val args by navArgs<DeleteUserAccountFragmentArgs>()
    private val binding by lazy { FragmentDeleteUserAccountBinding.inflate(layoutInflater) }
    private val adapterDelete by lazy { DeleteImagesAdaptor() }
    private val viewModelDelete by viewModels<DeleteViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.rvDeleteFoto.adapter = adapterDelete
        clickListener()
//        getImageById()
    }

    private fun clickListener() = with(binding) {
        deletePost.setOnClickListener {
            deletePost.hideView()
            progressBar2.showView()
            deletePost()
        }
        closeImageDelete.setOnClickListener {
            profile()
        }
        button.setOnClickListener { profile() }
    }
//
//    private fun getImageById() {
//        lifecycleScope.launchWhenStarted {
//            viewModelGet.onePosts(objectId = args.deletePostId).collectLatest {
//                adapterDelete.postsImages = it.posts
//            }
//        }
//    }

    private fun deletePost()= with(binding) {
        lifecycleScope.launchWhenStarted {
            viewModelDelete.deleteUserPost(id = args.deletePostId).collectLatest {
                withContext(Dispatchers.IO) {
                    Thread.sleep(3000)
                }
                progressBar2.hideView()
                makeToast("Фото удалено!" , requireContext())
                button.showView()
                rvDeleteFoto.hideView()
                emtyImage.showView()

            }
        }
    }

    private fun profile() {
        findNavController().popBackStack()

    }
}