package com.makrosh.amarparcelandroid.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("token")
	val token: String? = null
)
