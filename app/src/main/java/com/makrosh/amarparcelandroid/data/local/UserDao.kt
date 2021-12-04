package com.makrosh.amarparcelandroid.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.makrosh.amarparcelandroid.data.model.Users

@Dao
interface UserDao {

    @Query("select * FROM Users")
    fun getAll(): List<Users>
}