package co.mvvm.sample.android.state

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

sealed class NetworkResult<out T>() {
    data class Loading(val show: Boolean): NetworkResult<Nothing>()
    data class Success<out T>(val value: T): NetworkResult<T>()
    data class Error(val msg: String): NetworkResult<Nothing>()
    object SessionExpire: NetworkResult<Nothing>()
}