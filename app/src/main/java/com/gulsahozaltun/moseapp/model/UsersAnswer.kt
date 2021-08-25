package com.gulsahozaltun.moseapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsersAnswer(
    @SerializedName("users")
    @Expose
    var users:List<Users>
) {

}