package co.mvvm.sample.android.network

import co.mvvm.sample.android.data.ImageItem
import retrofit2.Response
import retrofit2.http.GET

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

interface ApiRoute {

    @GET(AppConst.Route.IMAGES)
    suspend fun images(): Response<List<ImageItem>>
}