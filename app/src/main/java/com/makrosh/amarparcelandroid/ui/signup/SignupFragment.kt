package com.makrosh.amarparcelandroid.ui.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.makrosh.amarparcelandroid.R
import com.makrosh.amarparcelandroid.data.model.SignupRequest
import com.makrosh.amarparcelandroid.data.remote.Resource
import com.makrosh.amarparcelandroid.databinding.FragmentSignupBinding
import com.makrosh.amarparcelandroid.ui.BaseFragment
import com.makrosh.amarparcelandroid.ui.custom.SpinnerArrayAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment() {

    private lateinit var signupViewModel: SignupViewModel
    private var _binding: FragmentSignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signupViewModel = ViewModelProvider(this).get(SignupViewModel::class.java)

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        addSignupObserver()

        binding.acbSignup.setOnClickListener {
            if (binding.tiePhoneNumber.text.toString().isNotEmpty() && binding.tiePassword.text.toString().isNotEmpty()) {
                signupViewModel.submitSignup(
                    SignupRequest(
                        binding.tiePhoneNumber.text.toString(),
                        binding.tiePassword.text.toString(),
                        1
                    )
                )
                binding.tiePhoneNumber.setText("")
                binding.tiePassword.setText("")
                val imm =
                    context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }
    }

    private fun initUI() {
        //hideBackButton()

        val seasonsList: MutableList<String> = mutableListOf()
        seasonsList.add("Category 1")
        seasonsList.add("Category 2")
        seasonsList.add("Category 3")
        SpinnerArrayAdapter(requireContext(), R.layout.spinner_prompt_header, seasonsList).also { adapter ->
            //adapter.setDropDownViewResource(R.layout.spinner_list_item)
            binding.acsCategory.adapter = adapter
        }
    }

    private fun addSignupObserver() {
        signupViewModel.signupResponse.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                    findNavController().navigate(SignupFragmentDirections.actionNavSignupToNavHome())
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Signup Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}