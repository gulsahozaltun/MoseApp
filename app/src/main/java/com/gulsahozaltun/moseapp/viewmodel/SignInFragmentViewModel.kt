package com.gulsahozaltun.moseapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Users
import com.gulsahozaltun.moseapp.model.UsersAnswer
import com.gulsahozaltun.moseapp.repos.UsersRepository
import com.gulsahozaltun.moseapp.retrofit.ApiUtils
import com.gulsahozaltun.moseapp.retrofit.UsersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragmentViewModel:ViewModel() {
    val usersList: MutableLiveData<Users>
    private val usersdao: UsersDaoInterface


    init {
        usersdao=ApiUtils.getUsersDaoInterface()
        usersList= MutableLiveData()
    }





    fun signUser(mail_adres: String,sifre: String){
        usersdao.signIn(mail_adres, sifre).enqueue(object : Callback<UsersAnswer> {
            override fun onResponse(call: Call<UsersAnswer>?, response: Response<UsersAnswer>?) {
                val customer= response!!.body()?.user
                for (i in customer!!){
                    if(i.giriskontrol==1){
                        usersList.value=i
                        Log.e("basardik beee", response.body().toString())
                    }
                    else{
                        usersList.value=null
                    }
                }
            }

            override fun onFailure(call: Call<UsersAnswer>?, t: Throwable?) {
                Log.e("why godd",t.toString())
            }

        })
    }
}