package com.wotin.mvvmpatternsearchmovieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class ItemCustomClass(
    @SerializedName("title")
    @Expose
    val title : String,

    @SerializedName("link")
    @Expose
    val link : String,

    @SerializedName("image")
    @Expose
    val image : String,

    @SerializedName("subtitle")
    @Expose
    val subTitle : String,

    @SerializedName("pubDate")
    @Expose
    val pubDate : String,

    @SerializedName("director")
    @Expose
    val director : String,

    @SerializedName("userRating")
    @Expose
    val userRating : String
) {
    override fun toString(): String {
        return "title: $title, link: $link, image: $image, subTitle: $subTitle, pubDate: $pubDate, director: $director, userRating: $userRating"
    }
}