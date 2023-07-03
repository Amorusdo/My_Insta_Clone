package com.example.myinstaclone.presentation.screens._comment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.databinding.FragmentCommentBinding
import com.example.myinstaclone.presentation.all.adapter.comments.CommentAdaptor
import com.example.myinstaclone.presentation.all.viewModel.PostViewModel
import com.example.myinstaclone.presentation.extantions.data
import com.example.myinstaclone.presentation.models.user_comment.UserCommentsUi
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ScreenCommentsFragment : Fragment() , TextWatcher {

    private val postId: String by lazy(LazyThreadSafetyMode.NONE) {
        ScreenCommentsFragmentArgs.fromBundle(requireArguments()).imageId
    }


    //    private val viewModel by viewModels<ScreenCommentsViewModel>()
    private val viewModelPost by viewModels<PostViewModel>()
    private val viewModelGet by viewModels<ViewModelHome>()
    private val binding by lazy { FragmentCommentBinding.inflate(layoutInflater) }
    private val adapter: CommentAdaptor by lazy { CommentAdaptor() }

    private var imagePostAvatar: ImageUi? = null
    private lateinit var sessionToken: String
    private lateinit var userComments: String

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        binding.commentsRv.adapter = adapter
        observeUser()
        userMeObserve()
        clikers()
        getComment()

    }

    private fun clikers() = with(binding) {
        commentsUserPublicComment.isEnabled = false
        commentsUserComment.addTextChangedListener(this@ScreenCommentsFragment)
        closeImage.setOnClickListener {
            findNavController().popBackStack()
        }
        commentsUserPublicComment.setOnClickListener {
            observe()
            binding.commentsUserComment.text = null
            hideKeyboard()
            newComment()
        }
    }

    override fun beforeTextChanged(s: CharSequence? , start: Int , count: Int , after: Int) {}
    override fun onTextChanged(s: CharSequence? , start: Int , before: Int , count: Int) {}

    override fun afterTextChanged(s: Editable?) = with(binding) {
        commentsUserPublicComment.isEnabled = commentsUserComment.text.toString().isNotEmpty()
    }
    private fun newComment() {
        Thread.sleep(2000)
        getComment()
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModelPost.createComment(createComments()).collectLatest {
            }
        }
    }

    private fun getComment() {
        lifecycleScope.launchWhenCreated {
            viewModelGet.getComment(idPost = postId).collectLatest {
                adapter.comment = it.comments.reversed()
            }
        }
    }

    private fun createComments(): UserCommentsUi = UserCommentsUi(
        userName = userComments ,
        userComments = binding.commentsUserComment.text.toString() ,
        idPostForComments = postId,
        commentImageUser = imagePostAvatar,
        data = data()
    )


    private fun observeUser() {
        lifecycleScope.launchWhenStarted {
            viewModelGet.user.observe(viewLifecycleOwner) {
                sessionToken = it.sessionToken
                Log.i("RUS" , "${it.sessionToken}")

            }
        }
    }

    private fun userMeObserve() = with(binding) {
        lifecycleScope.launchWhenResumed {
            viewModelGet.userMe(sessionToken)
        }
        viewModelGet.userMee.observe(viewLifecycleOwner) {
            userComments = it.userFullName
            imagePostAvatar = it.userAvatar
            Picasso.get().load(it.userAvatar.imageUrl).into(binding.commentsUserFotos)
            binding.commentsUserComment.hint = "Comment as :${it.userFullName}"
            Log.i("RUS" , "${it.userAvatar}")
        }
    }

    private fun hideKeyboard() {
        // Получаем менеджер ввода
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Получаем фокусированное представление
        val focusedView: View? = activity?.currentFocus

        // Если есть фокусированное представление, скрываем клавиатуру
        focusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

}
