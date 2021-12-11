package com.makrosh.amarparcelandroid.ui.login

import com.makrosh.amarparcelandroid.data.base.BaseRepository
import com.makrosh.amarparcelandroid.data.local.UserDao
import com.makrosh.amarparcelandroid.data.model.LoginRequest
import com.makrosh.amarparcelandroid.data.remote.*
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService, private val userDao: UserDao): BaseRepository() {

    suspend fun submitLogin(loginRequest: LoginRequest) = safeApiCall {
        apiService.submitLogin(loginRequest)
    }
}