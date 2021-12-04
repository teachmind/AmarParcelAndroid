package com.makrosh.amarparcelandroid.data.remote

import com.makrosh.amarparcelandroid.data.remote.Status.ERROR
import com.makrosh.amarparcelandroid.data.remote.Status.LOADING
import com.makrosh.amarparcelandroid.data.remote.Status.SUCCESS
import okhttp3.ResponseBody

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
sealed class Resource<out T>{
    data class Success<out T>(val value: T): Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()
}
