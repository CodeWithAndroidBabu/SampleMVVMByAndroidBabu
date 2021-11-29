package co.mvvm.sample.android.ui.imageshowing

import android.os.Bundle
import androidx.activity.viewModels
import co.mvvm.sample.android.R
import co.mvvm.sample.android.base.BaseActivity
import co.mvvm.sample.android.databinding.ActivityHomeBinding
import co.mvvm.sample.android.extension.show
import co.mvvm.sample.android.state.NetworkResult
import co.mvvm.sample.android.ui.imageshowing.viewmodel.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val viewModel by viewModels<ImagesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvImages.adapter = viewModel.adapter
        viewModel.getImages()
        observers()
    }
    private fun observers(){
        viewModel.getImagesObserver().observe(this, {
            when (it) {
                is NetworkResult.Loading -> {
                    binding.pbLayout.pb.show(it.show)
                }
                is NetworkResult.Error -> {
                    binding.pbLayout.pb.show(false)
                }
                is NetworkResult.SessionExpire -> {
                    binding.pbLayout.pb.show(false)
                }
                is NetworkResult.Success -> {
                    binding.pbLayout.pb.show(false)
                }
            }
        })
    }
}