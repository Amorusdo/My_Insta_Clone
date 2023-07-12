package com.example.myinstaclone.presentation.screens._post_media

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.databinding.FragmentPostMediaBinding
import com.example.myinstaclone.presentation.all.viewModel.PostViewModel
import com.example.myinstaclone.presentation.extantions.*
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import com.example.myinstaclone.presentation.screens._registration_user.RegistrationFragment
import com.parse.ParseFile
import com.parse.SaveCallback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

@AndroidEntryPoint
class PostMediaFragment : Fragment(){

    private val binding by lazy { FragmentPostMediaBinding.inflate(layoutInflater) }
    private val viewModelPost by viewModels<PostViewModel>()
    private val viewModelGet by viewModels<ViewModelHome>()

    private lateinit var userId: String
    private val values: ContentValues by lazy { ContentValues() }
    private var imageUriAdd: Uri? = null
    private var pickImageIntent: Intent? = null
    private var cameraUri: Uri? = null
    private var selectedImage: Bitmap? = null
    private var imageFileAdd: ParseFile? = null
    private var imagePostAvatar: ImageUi? = null
    private lateinit var userName: String
    private var userLogin: String? = null
    private  var sessionToken: String? = null
    private lateinit var userFullName: String


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        ifHasPermission()

    }

    private fun ifHasPermission() = with(binding) {
        downLoadPostBatton.hideView()
        discriptionText.hideView()
        if (! hasPermissions(requireContext() , *RegistrationFragment.PERMISSIONS)) {
            ActivityCompat.requestPermissions(
                requireActivity() ,
                RegistrationFragment.PERMISSIONS ,
                RegistrationFragment.PERMISSION_ALL
            )
            observeUsers()
            clickListener()
            isClick(binding.downLoadPostBatton)
        }
    }

    private fun clickListener() = with(binding) {
        galleryImage.setOnClickListener { pickFromGallery() }
        cameraImage.setOnClickListener { openCamera() }
        downLoadPostBatton.setOnClickListener { observe()
            downLoadPostBatton.hideView()
            discriptionText.hideView()
        }
    }

    private fun userMeObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                sessionToken?.let { viewModelGet.userMe(it) }
            }
        }
        viewModelGet.userMee.observe(viewLifecycleOwner) { user ->
            sessionToken = user.sessionToken
            userFullName = user.userFullName
            userName = user.userEmail
            imagePostAvatar = user.userAvatar
        }
    }


    private fun observeUsers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelGet.user.observe(viewLifecycleOwner) { user ->
                    userId = user.objectId
                    sessionToken = user.sessionToken
                }
            }
        }
        userMeObserve()
    }


    private fun createPost(): PostUi = PostUi(
        objectsId = "" ,
        postImage = imagePostUi ,
        binding.discriptionText.text.toString() ,
        postId = "jk" ,
        avatarName = imagePostAvatar ,
        userImagePost = userLogin ,
        postHolderName = userFullName ,
        likes = 0,
    )

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModelPost.createPost(createPost()).collectLatest {
                    findNavController().popBackStack()
                }
            }
        }
    }
    private fun pickFromGallery() {
        pickImageIntent = Intent(
            Intent.ACTION_PICK ,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        pickImageIntent?.type = "image/*"
        pickImageIntent?.putExtra(Intent.EXTRA_MIME_TYPES ,RegistrationFragment.MIME_TYPES)
        startActivityForResult(pickImageIntent !!,RegistrationFragment.IMAGE_PICK_CODE)
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
            imageUriAdd = cameraUri
            getImage()
        }
        if (resultCode == Activity.RESULT_OK && requestCode == RegistrationFragment.IMAGE_PICK_CODE && data != null) {
            imageUriAdd = data.data
            getImage()
        }

    }

    private fun getImage() = with(binding) {
        if (imageUriAdd != null) {
            Picasso.get().load(imageUriAdd).into(foto)
            uploadImage()
        }
    }

    private fun uploadImage() = with(binding) {
        btMainNavigation.hideView()
        progressBar.showView()
        val steam = ByteArrayOutputStream()
        selectedImage =
            MediaStore.Images.Media.getBitmap(requireContext().contentResolver , imageUriAdd)
        selectedImage?.compress(Bitmap.CompressFormat.PNG , 15 , steam)
        val byteArray = steam.toByteArray()
        val parseFile = ParseFile("image.png" , byteArray)
        parseFile.saveInBackground(SaveCallback { e ->
            if (e == null) {
                makeToast("Image is saved" , requireContext())
                imageFileAdd = parseFile
                parseFileToImage(imageFileAdd !!)
                progressBar.hideView()
                downLoadPostBatton.showView()
                discriptionText.showView()
            } else makeToast("Failed is image" , requireContext())
        })
    }
}
