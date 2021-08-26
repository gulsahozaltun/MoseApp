package com.gulsahozaltun.moseapp.retrofit

import com.gulsahozaltun.moseapp.retrofit.RetrofitClient.Companion.getClient

class ApiUtils {

    companion object{
        //bu url ile kisilerDao daki url birlesip calisacak
        val BASE_URL:String="http://api.canerture.com/moseapp/"


        fun getUsersDaoInterface(): UsersDaoInterface {
            return getClient(BASE_URL).create(UsersDaoInterface::class.java)
        }

        fun getMosesDaoInterface(): MosesDaoInterface {
            return getClient(BASE_URL).create(MosesDaoInterface::class.java)
        }


    }


}