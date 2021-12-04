package com.makrosh.amarparcelandroid.data.remote

import androidx.lifecycle.LiveData
import com.makrosh.amarparcelandroid.data.model.SignupRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("signup")
    suspend fun submitSignup(@Body signupRequest: SignupRequest): BaseApiModel<String>
}