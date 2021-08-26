package com.gulsahozaltun.moseapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Moses(
    @SerializedName("mosetur")
    @Expose
    var mosetur:String,
    @SerializedName("adi")
    @Expose
    var adi:String,
    @SerializedName("turu")
    @Expose
    var turu:String,
    @SerializedName("sure")
    @Expose
    var sure:String,
    @SerializedName("imdb_puan")
    @Expose
    var imdb_puan:String,
    @SerializedName("gorsel_url")
    @Expose
    var gorsel_url:String,
    @SerializedName("yonetmen")
    @Expose
    var yonetmen:String,
    @SerializedName("ulke")
    @Expose
    var ulke:String,
    @SerializedName("hakkinda")
    @Expose
    var hakkinda:String,
    @SerializedName("fragman_url")
    @Expose
    var fragman_url:String,
    @SerializedName("yeni_mi")
    @Expose
    var yeni_mi:String,
/*    @SerializedName("fav")
    @Expose
    var fav:Int*/

):Serializable {
}