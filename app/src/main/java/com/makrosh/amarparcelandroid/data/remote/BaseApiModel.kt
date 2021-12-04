package com.makrosh.amarparcelandroid.data.remote

import com.google.gson.annotations.SerializedName

data class BaseApiModel<T>(
    @SerializedName("message")
    val message: String? = null,

    @SerializedName("error")
    val error: Error? = null,

    @SerializedName("data")
    val data: T? = null,
)
