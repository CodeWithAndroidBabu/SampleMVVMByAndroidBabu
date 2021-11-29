package co.mvvm.sample.android.extension

import android.content.Context
import android.view.View
import android.widget.Toast

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

fun Context.showToast(msg: String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}

fun View.show(shouldShow: Boolean){
    visibility = if(shouldShow) View.VISIBLE else View.GONE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}