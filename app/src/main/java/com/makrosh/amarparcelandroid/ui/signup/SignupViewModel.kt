package com.makrosh.amarparcelandroid.ui.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makrosh.amarparcelandroid.data.model.SignupRequest
import com.makrosh.amarparcelandroid.data.remote.BaseApiModel
import com.makrosh.amarparcelandroid.data.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val signupRepository: SignupRepository): ViewModel() {

    private val _signupResponse: MutableLiveData<Resource<BaseApiModel<String>>> = MutableLiveData()
    val signupResponse: LiveData<Resource<BaseApiModel<String>>>
        get() = _signupResponse

    fun submitSignup(signupRequest: SignupRequest) =
        viewModelScope.launch {
            _signupResponse.value = signupRepository.submitLogin(signupRequest)
        }
}