package co.mvvm.sample.android.extension

import android.annotation.SuppressLint
import android.widget.ImageView
import co.mvvm.sample.android.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

@SuppressLint("CheckResult")
fun ImageView.setGlideImg(img: Any, isCircle: Boolean = false,placeHolder: Int = R.drawable.place_holder_img){
    val glide = Glide.with(this).load(img).placeholder(placeHolder)
    if(isCircle) glide.apply(RequestOptions.centerCropTransform())
    glide.into(this)
}