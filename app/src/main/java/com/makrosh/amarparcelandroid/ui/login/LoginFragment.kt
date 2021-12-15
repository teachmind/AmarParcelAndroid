package com.makrosh.amarparcelandroid.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.makrosh.amarparcelandroid.data.remote.Resource
import com.makrosh.amarparcelandroid.databinding.FragmentLoginBinding
import com.makrosh.amarparcelandroid.ui.BaseFragment
import com.makrosh.amarparcelandroid.ui.splash.SplashFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: BaseFragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun addLoginObserver() {
        loginViewModel.loginResponse.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                    //findNavController().navigate(SignupFragmentDirections.actionNavSignupToNavHome())
                }
                is Resource.Failure -> {
                    //Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initUI() {
        hideBackButton()

        binding.tvForgetPassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgetPasswordFragment())
        }

        binding.acbSignup.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNavSignup())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}