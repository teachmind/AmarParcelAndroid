package com.makrosh.amarparcelandroid.ui.forget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makrosh.amarparcelandroid.databinding.FragmentForgetPasswordBinding
import com.makrosh.amarparcelandroid.ui.BaseFragment

class ForgetPasswordFragment: BaseFragment() {

    private var _binding: FragmentForgetPasswordBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
}