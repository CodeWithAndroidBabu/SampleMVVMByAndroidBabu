package co.mvvm.sample.android.data

import com.google.gson.annotations.SerializedName

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

data class ImageItem(
    @SerializedName("author")
    var author: String = "",
    @SerializedName("download_url")
    var downloadUrl: String = "",
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("id")
    var id: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("width")
    var width: Int = 0)