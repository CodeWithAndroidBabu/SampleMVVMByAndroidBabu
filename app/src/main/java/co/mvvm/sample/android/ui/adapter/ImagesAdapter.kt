package co.mvvm.sample.android.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.mvvm.sample.android.R
import co.mvvm.sample.android.data.ImageItem
import co.mvvm.sample.android.databinding.HolderImagesLayoutBinding
import co.mvvm.sample.android.extension.setGlideImg

/**Created by DRaj Pandey on 29,November,2021 deeprajpandey5@gmail.com **/

class ImagesAdapter(private val images: List<ImageItem>) : RecyclerView.Adapter<ImagesAdapter.ImageHolder>(){

    lateinit var context: Context

    inner class ImageHolder(private val binding: HolderImagesLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ImageItem){
            binding.apply {
                tvAuthorName.text = item.author
                iv.setGlideImg(item.downloadUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        context = parent.context
        return ImageHolder(
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.holder_images_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

}