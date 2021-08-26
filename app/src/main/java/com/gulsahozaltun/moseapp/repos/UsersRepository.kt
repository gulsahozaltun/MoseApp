package com.gulsahozaltun.moseapp.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsahozaltun.moseapp.model.CRUDAnswer
import com.gulsahozaltun.moseapp.model.Users
import com.gulsahozaltun.moseapp.model.UsersAnswer
import com.gulsahozaltun.moseapp.retrofit.ApiUtils
import com.gulsahozaltun.moseapp.retrofit.UsersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {
    private val usersdao:UsersDaoInterface
    var usersList:MutableLiveData<Users>

    init {
        usersdao= ApiUtils.getUsersDaoInterface()
        usersList = MutableLiveData()
    }




    fun addUser(mail_adres: String, sifre: String, ad_soyad: String, telefon: String){
        usersdao.signUp(mail_adres, sifre, ad_soyad, telefon).enqueue(object :Callback<CRUDAnswer>{
            override fun onResponse(call: Call<CRUDAnswer>?, response: Response<CRUDAnswer>?) {
                Log.e("se=uccsadsdafa",response!!.body().toString())
                Log.e("basariliii","Adadadafzhjhgfds")


            }

            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {
                Log.e("fail olduuu",t.toString()!!)
            }

        })
    }



}