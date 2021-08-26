package com.gulsahozaltun.moseapp.retrofit

import com.gulsahozaltun.moseapp.model.CRUDAnswer
import com.gulsahozaltun.moseapp.model.MosesAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MosesDaoInterface {
    @GET("all_movies.php")
    fun allMoses(): Call<MosesAnswer>

    @POST("mose_ekle.php")
    @FormUrlEncoded
    fun moseEkle(@Field("mosetur") mosetur:String,
                  @Field("adi") adi:String,
                  @Field("turu") turu:String,
                  @Field("sure") sure:String,
                 @Field("imdb_puan") imdb_puan:String,
                 @Field("gorsel_url") gorsel_url:String,
                 @Field("yonetmen") yonetmen:String,
                 @Field("ulke") ulke:String,
                 @Field("hakkinda") hakkinda:String,
                 @Field("fragman_url") fragman_url:String,
                  @Field("yeni_mi") yeni_mi:String):Call<CRUDAnswer>
}


