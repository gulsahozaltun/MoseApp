package com.gulsahozaltun.moseapp.retrofit

import com.gulsahozaltun.moseapp.model.CRUDAnswer
import com.gulsahozaltun.moseapp.model.Users
import com.gulsahozaltun.moseapp.model.UsersAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersDaoInterface {

    @POST("sign_up.php")
    @FormUrlEncoded
    fun signUp(@Field("mail_adres") mail_adres:String,
               @Field("sifre") sifre:String,
               @Field("ad_soyad") ad_soyad:String,
               @Field("telefon") telefon:String): Call<CRUDAnswer>

    @POST("sign_in.php")
    @FormUrlEncoded
    fun signIn(@Field("mail_adres") mail_adres: String,
               @Field("sifre")sifre: String):Call<UsersAnswer>

}