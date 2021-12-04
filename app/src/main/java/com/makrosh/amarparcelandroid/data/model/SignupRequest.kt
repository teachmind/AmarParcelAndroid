package com.makrosh.amarparcelandroid.data.model

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @field:SerializedName("phone_number")
    val phoneNumber: String,

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("category_id")
    val categoryId: Int
)
