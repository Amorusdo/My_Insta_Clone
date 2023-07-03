package com.example.myinstaclone.presentation.screens._edit_profile

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentEditProfileBinding
import com.example.myinstaclone.presentation.all.viewModel.PutViewModel
import com.example.myinstaclone.presentation.extantions.*
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_registration.UserRegistrationUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import com.example.myinstaclone.presentation.screens._registration_user.RegistrationFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.parse.ParseFile
import com.parse.SaveCallback
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream


class EditProfileFragment : Fragment(), TextWatcher {

    private val viewModelPut by viewModels<PutViewModel>()
    private val viewModelGet by viewModels<ViewModelHome>()
    private val binding by lazy { FragmentEditProfileBinding.inflate(layoutInflater) }

    private val values: ContentValues by lazy { ContentValues() }
    private var imageUri: Uri? = null
    private var pickImageIntent: Intent? = null
    private var cameraUri: Uri? = null
    private var selectedImage: Bitmap? = null
    private var imageFile: ParseFile? = null
    private lateinit var sessionToken: String
    private lateinit var idUpData: String
    private lateinit var userEmail: String
    private lateinit var idUser: String
    private lateinit var idForUpDataSignIn: String
    private lateinit var fillNames: String


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        ifHasPermissions()
    }

    private fun ifHasPermissions() {
        if (! hasPermissions(requireContext() ,*RegistrationFragment.PERMISSIONS)) {
            ActivityCompat.requestPermissions(
                requireActivity() ,
                RegistrationFragment.PERMISSIONS ,
                RegistrationFragment.PERMISSION_ALL
            )
            observeUser()
            userMeObserve()
            clikers()
        }
    }


    private fun clikers() = with(binding) {
        saveImage.isEnabled = false
        fillName.addTextChangedListener(this@EditProfileFragment)
        closeImage.setOnClickListener {
            profile()
        }
        changeFoto.setOnClickListener {
            openDialogSheet()
        }
        saveImage.setOnClickListener {
            upDataUser()
            upDataUserReg()
            profile()
        }
    }

    override fun afterTextChanged(s: Editable?) = with(binding) {
        saveImage.isEnabled = fillName.text.toString().isNotEmpty()
    }

    override fun beforeTextChanged(s: CharSequence? , start: Int , count: Int , after: Int) {}
    override fun onTextChanged(s: CharSequence? , start: Int , before: Int , count: Int) {}


    private fun editProfile() = with(binding) {
        if (changeFoto.isClickable) {
            imageEditUi
        } else imageEditUi
    }

    private fun observeUser() {
        lifecycleScope.launchWhenStarted {
            viewModelGet.user.observe(viewLifecycleOwner) {
                sessionToken = it.sessionToken
                idUser = it.userSingInId
            }
        }
    }

    private fun userMeObserve() = with(binding) {
        lifecycleScope.launchWhenResumed {
            viewModelGet.userMe(sessionToken)
        }
        viewModelGet.userMee.observe(viewLifecycleOwner) {
            sessionToken = it.sessionToken
            idUpData = it.objectId
            idForUpDataSignIn = it.userSingInId
            userEmail = it.userEmail
            fillNames = it.userFullName
            fillName.hint = it.userFullName
            userMail.hint = it.userEmail
            imageEditUi = it.userAvatar
            Picasso.get().load(it.userAvatar.imageUrl).into(avatar)
        }
    }

    private fun upDataUser() = with(binding) {
        viewModelPut.upDateUser(
            id = idUpData ,
            userUi = UserRegistrationUi(
                objectId = idUpData ,
                userFullName = (if (fillName.text.toString()
                        .isEmpty()
                ) fillNames else fillName.text.toString()
                        ).toString() ,
                userEmail = userEmail ,
                userGender = true ,
                phoneNumber = phone.text.toString() ,
                profileBio = aboutMe.text.toString() ,
                userFollower = 1 ,
                userFollowing = 1 ,
                userCountPosts = countPost ,
                userAvatar = editProfile() ,
                userPassword = null ,
                sessionToken = sessionToken ,
                userSingInId = idForUpDataSignIn ,
                createUserAt = data()
            ) ,
            sessionToken = sessionToken ,
        )
    }

    private fun upDataUserReg() = with(binding) {
        viewModelPut.upDateUserSing(
            id = idForUpDataSignIn ,
            userUi = UserSignInUi(
                id = idForUpDataSignIn ,
                userFullName = fillName.text.toString() ,
                userEmail = userEmail ,
                userAge = age.text.toString() ,
                userGender = true ,
                phoneNumber = phone.text.toString() ,
                userBio = aboutMe.text.toString() ,
                userFollower = 1 ,
                userFollowing = 1 ,
                userCountPosts = countPost ,
                userAvatar = editProfile() ,
                userId = "userIdForUpData.userId"
            ) ,
        )
    }

    fun profile() {
        findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragmentToProfileFragment())
    }

    private fun pickFromGallery() {
        pickImageIntent = Intent(
            Intent.ACTION_PICK ,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        pickImageIntent?.type = "image/*"
        pickImageIntent?.putExtra(Intent.EXTRA_MIME_TYPES , RegistrationFragment.MIME_TYPES)
        startActivityForResult(pickImageIntent!! , RegistrationFragment.IMAGE_PICK_CODE)
    }

    private fun openDialogSheet() {
        val bottomSheet = BottomSheetDialog(requireContext())
        bottomSheet.setContentView(R.layout._bottom_sheet)
        val cancelBtn = bottomSheet.findViewById<MaterialButton>(R.id.sheet_btn)
        val takePicture = bottomSheet.findViewById<MaterialCardView>(R.id.camera_card)
        val openGallery = bottomSheet.findViewById<MaterialCardView>(R.id.gallery_card)
        cancelBtn?.setOnClickListener {
            bottomSheet.dismiss()
        }
        takePicture?.setOnClickListener {
            openCamera()
            bottomSheet.dismiss()
        }
        openGallery?.setOnClickListener {
            pickFromGallery()
            bottomSheet.dismiss()
        }
        bottomSheet.setCancelable(true)
        bottomSheet.show()
    }


    private fun openCamera() {
        values.put(MediaStore.Images.Media.TITLE , "MyPicture")
        values.put(
            MediaStore.Images.Media.DESCRIPTION ,
            "Photo taken on " + System.currentTimeMillis()
        )
        cameraUri = requireContext().contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI ,
            values
        )
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT , cameraUri);
        startActivityForResult(cameraIntent , RegistrationFragment.REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int , resultCode: Int , data: Intent?) {
        super.onActivityResult(requestCode , resultCode , data)
        if (resultCode == Activity.RESULT_OK && requestCode == RegistrationFragment.REQUEST_CODE) {
            imageUri = cameraUri
            getImage()
        }
        if (resultCode == Activity.RESULT_OK && requestCode == RegistrationFragment.IMAGE_PICK_CODE && data != null) {
            imageUri = data.data
            getImage()
        }
    }

    private fun getImage() {
        if (imageUri != null) {
            Picasso.get().load(imageUri).into(binding.avatar)
            uploadImage()
        } else imageForEmpty
    }

    private fun uploadImage() = with(binding) {
        val steam = ByteArrayOutputStream()
        selectedImage =
            MediaStore.Images.Media.getBitmap(requireContext().contentResolver , imageUri)
        selectedImage?.compress(Bitmap.CompressFormat.JPEG , 10 , steam)
        val byteArray = steam.toByteArray()
        val parseFile = ParseFile("image.jpg" , byteArray)
        parseFile.saveInBackground(SaveCallback { e ->
            if (e == null) {
                makeToast("Image is saved" , requireContext())
                imageFile = parseFile
                parseFileToImag(imageFile !!)
                saveImage.isEnabled = true
            } else makeToast("Failed is image" , requireContext())
        })
    }

    companion object {
        val imageForEmpty = ImageUi(
            "File" ,
            "5f4e91fa2356ec1bc06fc0d3536192f1_profile_img.jpg" ,
            "https://parsefiles.back4app.com/19M1h2d0Ttcsdxdf09E1Q1ew3I4IO3s6TvMGbUWA/d1e8524a1135878edac3b7a855b71ffe_profile_img.jpg.jpg"
        )
    }
}
