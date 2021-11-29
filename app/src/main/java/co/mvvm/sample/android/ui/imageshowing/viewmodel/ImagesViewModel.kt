package co.mvvm.sample.android.ui.imageshowing.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.mvvm.sample.android.base.BaseViewModel
import co.mvvm.sample.android.data.ImageItem
import co.mvvm.sample.android.state.NetworkResult
import co.mvvm.sample.android.ui.adapter.ImagesAdapter
import co.mvvm.sample.android.ui.imageshowing.repo.ImagesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

@HiltViewModel
class ImagesViewModel @Inject constructor(private val imagesRepo: ImagesRepo): BaseViewModel(){
    private val images: MutableList<ImageItem> = arrayListOf()
    val adapter: ImagesAdapter = ImagesAdapter(images)

    private val getImagesObserver:MutableLiveData<NetworkResult<List<ImageItem>>> by lazy {
        MutableLiveData<NetworkResult<List<ImageItem>>>()
    }

    fun getImagesObserver(): LiveData<NetworkResult<List<ImageItem>>> = getImagesObserver

    fun getImages() = viewModelScope.launch {
        imagesRepo.imagesApiRequest().onStart {
            getImagesObserver.value = NetworkResult.Loading(true)
        }.catch {e->
            getImagesObserver.value = NetworkResult.Error(e.message ?: "Something went wrong")
        }.collect {
            getImagesObserver.value = NetworkResult.Loading(false)
            val value = (it as NetworkResult.Success).value
            images.addAll(value)
            adapter.notifyDataSetChanged()
        }
    }
}