package co.mvvm.sample.android.ui.imageshowing.repo

import co.mvvm.sample.android.base.BaseNetworkCall
import co.mvvm.sample.android.data.ImageItem
import co.mvvm.sample.android.network.ApiRoute
import co.mvvm.sample.android.state.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

class ImagesRepo @Inject constructor(private val apiRoute: ApiRoute): BaseNetworkCall(){

    suspend fun imagesApiRequest(): Flow<NetworkResult<List<ImageItem>>> {
        return flow { emit(
            networkRequest {
                apiRoute.images()
            }
        ) }.flowOn(Dispatchers.IO)
    }
}


