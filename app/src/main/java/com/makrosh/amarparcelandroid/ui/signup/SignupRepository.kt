package com.makrosh.amarparcelandroid.ui.signup

import com.makrosh.amarparcelandroid.data.base.BaseRepository
import com.makrosh.amarparcelandroid.data.local.UserDao
import com.makrosh.amarparcelandroid.data.model.SignupRequest
import com.makrosh.amarparcelandroid.data.remote.*
import javax.inject.Inject

class SignupRepository @Inject constructor(private val apiService: ApiService, private val userDao: UserDao): BaseRepository() {

    suspend fun submitLogin(signupRequest: SignupRequest) = safeApiCall {
        apiService.submitSignup(signupRequest)
    }
}