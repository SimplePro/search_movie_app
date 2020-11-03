package com.wotin.mvvmpatternsearchmovieapp.conversions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wotin.mvvmpatternsearchmovieapp.R

object BindingMovieImageConversions {

    @BindingAdapter("image_url")
    @JvmStatic
    fun loadImage(imageView: ImageView, imageUrl : String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .error(R.drawable.no)
            .into(imageView)
    }
}