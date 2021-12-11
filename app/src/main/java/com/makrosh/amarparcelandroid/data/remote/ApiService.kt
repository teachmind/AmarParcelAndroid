package com.makrosh.amarparcelandroid.data.remote

import com.makrosh.amarparcelandroid.data.model.LoginRequest
import com.makrosh.amarparcelandroid.data.model.LoginResponse
import com.makrosh.amarparcelandroid.data.model.SignupRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("signup")
    suspend fun submitSignup(@Body signupRequest: SignupRequest): BaseApiModel<String>

    @POST("login")
    suspend fun submitLogin(@Body loginRequest: LoginRequest): BaseApiModel<LoginResponse>
}