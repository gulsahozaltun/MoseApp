package com.gulsahozaltun.moseapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Users
import com.gulsahozaltun.moseapp.repos.UsersRepository

class SignInFragmentViewModel:ViewModel() {
    private val urepo=UsersRepository()
    var user=MutableLiveData<List<Users>>()


    init {
        user= urepo.userData()
    }
}