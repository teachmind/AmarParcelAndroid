package com.makrosh.amarparcelandroid.ui

import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    fun showBackButton() {
        (requireActivity() as MainActivity).showBackButton()
    }

    fun hideBackButton() {
        (requireActivity() as MainActivity).hideBackButton()
    }
}