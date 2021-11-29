package co.mvvm.sample.android.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

open class BaseActivity<T: ViewDataBinding>(val layout: Int) : AppCompatActivity() {
    lateinit var binding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layout)
    }
}