package com.makrosh.amarparcelandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makrosh.amarparcelandroid.data.model.LoginRequest
import com.makrosh.amarparcelandroid.data.model.LoginResponse
import com.makrosh.amarparcelandroid.data.remote.BaseApiModel
import com.makrosh.amarparcelandroid.data.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository): ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<BaseApiModel<LoginResponse>>> = MutableLiveData()
    val loginResponse: LiveData<Resource<BaseApiModel<LoginResponse>>>
        get() = _loginResponse

    fun submitSignup(loginRequest: LoginRequest) =
        viewModelScope.launch {
            _loginResponse.value = loginRepository.submitLogin(loginRequest)
        }
}