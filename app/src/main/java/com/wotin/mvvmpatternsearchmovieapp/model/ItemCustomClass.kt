package com.wotin.mvvmpatternsearchmovieapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
class ItemCustomClass(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    val title : String,

    @ColumnInfo(name = "link")
    @SerializedName("link")
    @Expose
    val link : String,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    @Expose
    val image : String,

    @ColumnInfo(name = "subTitle")
    @SerializedName("subtitle")
    @Expose
    val subTitle : String,

    @ColumnInfo(name = "pubDate")
    @SerializedName("pubDate")
    @Expose
    val pubDate : String,

    @ColumnInfo(name = "director")
    @SerializedName("director")
    @Expose
    val director : String,

    @ColumnInfo(name = "userRating")
    @SerializedName("userRating")
    @Expose
    val userRating : String,

    @PrimaryKey(autoGenerate = true)
    val id : Long?
) {
    override fun toString(): String {
        return "title: $title, link: $link, image: $image, subTitle: $subTitle, pubDate: $pubDate, director: $director, userRating: $userRating"
    }
}