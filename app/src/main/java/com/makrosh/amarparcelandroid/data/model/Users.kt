package com.makrosh.amarparcelandroid.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Users(
    @field:SerializedName("id")
    @PrimaryKey
    val id: Int = 0,

    @field:SerializedName("code")
    val code: String? = null,
)
