package com.example.myinstaclone.presentation.screens._registration_user

import android.Manifest
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.databinding.FragmentRegistrationBinding
import com.example.myinstaclone.presentation.all.viewModel.PostViewModel
import com.example.myinstaclone.presentation.all.viewModel.PutViewModel
import com.example.myinstaclone.presentation.extantions.data
import com.example.myinstaclone.presentation.extantions.makeToast
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import kotlinx.coroutines.flow.collectLatest


class RegistrationFragment : Fragment(), TextWatcher {

    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<PostViewModel>()
    private val viewModePut by viewModels<PutViewModel>()


    private var bio: String? = null
    private var userAge: String? = null
    private var userGender: Boolean? = null
    private var phoneNumber: String? = null
    private var userFollower: Int? = null
    private var userFollowing: Int? = null
    private var userPosts: Int? = null
    private lateinit var id: String


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        clickListener()
        observeSing()
    }

    private fun clickListener() = with(binding) {
        registrationBtn.isEnabled = false
        interFullName.addTextChangedListener(this@RegistrationFragment)
        pSignUp.addTextChangedListener(this@RegistrationFragment)
        next.setOnClickListener {
            if (interEmail.text.isNullOrEmpty()) {
                makeToast("Enter your email" , requireContext())
            } else {
                textCreatePassword.visibility = View.VISIBLE
                next.visibility = View.GONE
                registrationBtn.visibility = View.VISIBLE
                pSignUp.visibility = View.VISIBLE
                interFullName.visibility = View.VISIBLE
                textCreateLogin.visibility = View.VISIBLE
                textCreateLogin.visibility = View.VISIBLE
                textEnterEmail.visibility = View.GONE
                interEmail.visibility = View.GONE
                image3.visibility = View.INVISIBLE
            }
        }

        registrationBtn.setOnClickListener {
            upDataUserReg()
            observe()
        }
    }

    private fun launchSingFragment() {
        findNavController().navigate(
            RegistrationFragmentDirections.actionRegistrationFragmentToSignInFragment()
        )
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.signUpUser(signUpUser()).collectLatest {
                launchSingFragment()
            }
        }
    }


    private fun signUpUser(): UserRegistrationUi = UserRegistrationUi(
        objectId = "" ,
        binding.interFullName.text.toString() ,
        binding.interEmail.text.toString() ,
        userGender = true ,
        phoneNumber = phoneNumber ,
        profileBio = bio ,
        userFollower = userFollower ,
        userFollowing = userFollowing ,
        userCountPosts = userPosts ,
        userAvatar = imageForEmpty ,
        binding.pSignUp.text.toString() ,
        sessionToken = "" ,
        userSingInId = id ,
        createUserAt = data() ,
    )

    private fun signInUser(): UserSignInUi = UserSignInUi(
        id = "" ,
        binding.interFullName.text.toString() ,
        binding.interEmail.text.toString() ,
        userAge = userAge ,
        userGender = userGender ,
        phoneNumber = phoneNumber ,
        userBio = bio ,
        userFollower = userFollower ,
        userFollowing = userFollowing ,
        userCountPosts = userPosts ,
        userAvatar = imageForEmpty ,
        userId = ""
    )


    private fun upDataUserReg() {
        viewModePut.upDateUserSing(
            id = id ,
            userUi = UserSignInUi(
                id = id ,
                userFullName = binding.interFullName.text.toString() ,
                userEmail = binding.interEmail.text.toString() ,
                userAge = userAge ,
                userGender = true ,
                phoneNumber = phoneNumber ,
                userBio = bio ,
                userFollower = userFollower ,
                userFollowing = userFollowing ,
                userCountPosts = userPosts ,
                userAvatar = imageForEmpty ,
                userId = "userIdForUpData.userId"
            ) ,
        )
    }

    private fun observeSing() {
        lifecycleScope.launchWhenStarted {
            viewModel.singIn(signInUser()).collect() {
                id = it.userId

            }
        }
    }

    companion object {
        const val REQUEST_CODE = 200
        var PERMISSION_ALL = 1
        const val IMAGE_PICK_CODE = 100
        var PERMISSIONS = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE ,
            Manifest.permission.CAMERA
        )
        val MIME_TYPES = arrayOf("image/jpeg" , "image/png")
        val imageForEmpty = ImageUi(
            "File" ,
            "5f4e91fa2356ec1bc06fc0d3536192f1_profile_img.jpg" ,
            "https://parsefiles.back4app.com/19M1h2d0Ttcsdxdf09E1Q1ew3I4IO3s6TvMGbUWA/d1e8524a1135878edac3b7a855b71ffe_profile_img.jpg.jpg"
        )
    }
    override fun afterTextChanged(s: Editable?)= with(binding) {
        registrationBtn .isEnabled = interFullName.text.toString().isNotEmpty()
        registrationBtn.isEnabled = pSignUp.text.toString().isNotEmpty()
    }
    override fun beforeTextChanged(s: CharSequence? , start: Int , count: Int , after: Int) {}

    override fun onTextChanged(s: CharSequence? , start: Int , before: Int , count: Int) {}


}