package co.mvvm.sample.android.base

import co.mvvm.sample.android.state.NetworkResult
import retrofit2.Response
import java.lang.Exception

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

abstract class BaseNetworkCall {
    suspend fun <T> networkRequest(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    return NetworkResult.Success(it)
                }
            }
            return NetworkResult.Error(response.message())
        } catch (e: Exception) {
            val msg = e.message ?: "Something went wrong"
            return NetworkResult.Error(msg)
        }
    }
}