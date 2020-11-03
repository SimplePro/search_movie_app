package com.wotin.mvvmpatternsearchmovieapp.conversions

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wotin.mvvmpatternsearchmovieapp.R

object BindingMovieRatingBarConversions {
    @BindingAdapter("rating")
    @JvmStatic
    fun setRating(ratingBar: RatingBar, rating : String) {
        ratingBar.rating = rating.toFloat() / 2
    }
}