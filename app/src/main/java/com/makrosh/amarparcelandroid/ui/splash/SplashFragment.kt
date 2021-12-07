package com.makrosh.amarparcelandroid.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.makrosh.amarparcelandroid.databinding.FragmentSplashBinding
import com.makrosh.amarparcelandroid.ui.BaseFragment

class SplashFragment : BaseFragment() {

    private lateinit var splashFragmentViewModel: SplashFragmentViewModel
    private var _binding: FragmentSplashBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        splashFragmentViewModel =
            ViewModelProvider(this).get(SplashFragmentViewModel::class.java)

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSplash
        splashFragmentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //hideBackButton()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNavSignup())
            }, 3000
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}