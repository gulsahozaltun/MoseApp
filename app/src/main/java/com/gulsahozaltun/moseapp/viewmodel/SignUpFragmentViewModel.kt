package com.gulsahozaltun.moseapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.repos.UsersRepository

class SignUpFragmentViewModel:ViewModel() {
    val urepo=UsersRepository()
    fun addUser(mail_adres: String, sifre: String, ad_soyad: String, telefon: String){
        urepo.addUser(mail_adres, sifre, ad_soyad, telefon)
        Log.e("gelenlerr", mail_adres+sifre+ad_soyad+telefon)
    }

}