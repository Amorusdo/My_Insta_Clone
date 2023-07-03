package com.example.myinstaclone.presentation.screens._sign_in

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentSignInBinding
import com.example.myinstaclone.presentation.extantions.goneView
import com.example.myinstaclone.presentation.extantions.makeToast
import com.example.myinstaclone.presentation.screens._home.ViewModelHome
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment(), TextWatcher {

    private val binding by lazy { FragmentSignInBinding.inflate(layoutInflater) }
    private val viewModelGet by viewModels<ViewModelHome>()


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        visibleNav()
        observe()
        clickListener()

    }

    private fun clickListener() = with(binding) {
        registrationBtn.isEnabled = false
        interFullName.addTextChangedListener(this@SignInFragment)
        passwor.addTextChangedListener(this@SignInFragment)
        registrationBtn.setOnClickListener {
            login()
            it.hideKeyboard()

        }
        singInBtn.setOnClickListener {
            launchSingIn()
            it.hideKeyboard()
        }

    }

    private fun launchHome() {
        findNavController().navigate(
            SignInFragmentDirections.actionSignInFragmentToHomeFragment()
        )
    }

    private fun launchSingIn() {
        findNavController().navigate(
            SignInFragmentDirections.actionSignInFragmentToRegistrationFragment()
        )
    }

    private fun observe() {
        viewModelGet.user.observe(viewLifecycleOwner) {
            launchHome()
        }
        viewModelGet.error.observe(viewLifecycleOwner) {
            makeToast("Неправильный пароль или логин" , requireContext())
        }
    }

    private fun login() = with(binding) {
        viewModelGet.login(
            login = interFullName.text.toString() ,
            password = passwor.text.toString()

        )
    }

    private fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken , 0)
    }

    private fun visibleNav() {
        val navView =
            requireActivity().findViewById<BottomNavigationView>(R.id.main_bottom_nav_view)
        navView.goneView()
    }

    override fun beforeTextChanged(s: CharSequence? , start: Int , count: Int , after: Int) {}

    override fun onTextChanged(s: CharSequence? , start: Int , before: Int , count: Int) {}

    override fun afterTextChanged(s: Editable?) = with(binding) {
        registrationBtn.isEnabled = interFullName.text.toString().isNotEmpty()
        registrationBtn.isEnabled = passwor.text.toString().isNotEmpty()
    }

}