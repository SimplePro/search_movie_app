package com.wotin.mvvmpatternsearchmovieapp.model

import android.content.ClipData
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieCustomClass(
    @SerializedName("items")
    @Expose
    val items : ArrayList<ItemCustomClass>
) {
    override fun toString(): String {
        var str = ""
        items.forEach {item ->
           str += "\n$item"
        }
        return "items: $str"
    }
}