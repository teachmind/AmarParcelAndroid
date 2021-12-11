package com.makrosh.amarparcelandroid.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("phone_number")
    val phoneNumber: String,

    @field:SerializedName("password")
    val password: String
)
